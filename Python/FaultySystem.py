class Graph: 
	def __init__(self, V): 
		self.V = V 
		self.adj = [[] for i in range(V)] 
	def addEdge(self, u, v): 
		self.adj[u].append(v)
		self.adj[v].append(u)
	def delEdge(self, u, v):
		self.adj[v].remove(u)
		self.adj[u].remove(v)
	def DFS(self, v, visited):
		visited[v] = True
		i = 0
		while i != len(self.adj[v]): 
			if (not visited[self.adj[v][i]]): 
				self.DFS(self.adj[v][i], visited) 
			i += 1
	def isConnected(self): 
		visited = [False] * self.V
		self.DFS(0, visited)
		for i in range(1, self.V): 
			if (visited[i] == False): 
				return False
		return True
	def isBridge(self, u, v):
		indU = self.adj[v].index(u) 
		indV = self.adj[u].index(v) 
		del self.adj[u][indV] 
		del self.adj[v][indU] 
		res = self.isConnected()
		self.addEdge(u, v)
		return (res == False)
if __name__ == '__main__':
	t = int(input())
	for i in range(0, t):
		n , m = map(int, input().split())
		g1 = Graph(n)
		g2 = Graph(n)
		u1 = []
		u2 = []
		v1 = []
		v2 = []
		for j in range(0, m):
			p , q = map(int, input().split())
			g1.addEdge(p - 1, q - 1)
			u1.append(p - 1)
			v1.append(q - 1)
		for j in range(0, m):
			p , q = map(int, input().split())
			g2.addEdge(p - 1, q - 1)
			u2.append(p - 1)
			v2.append(q - 1)
		res = 0
		for j in range(0, m):
			if((not g1.isBridge(u1[j], v1[j])) and (not g2.isBridge(u2[j], v2[j]))):
				res += 1
				g1.delEdge(u1[j], v1[j])
				g2.delEdge(u2[j], v2[j])
		print(m - res)