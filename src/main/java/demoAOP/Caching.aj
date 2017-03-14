package demoAOP;

public aspect Caching {
	private int Expression.cache;
	private boolean Expression.cacheValid = false;
	private Expression Expression.ancestor = null;
	
	public int Expression.getCache() {
		return cache;
	}

	public void Expression.setCache(int cache) {
		this.cache = cache;
	}

	public boolean Expression.isCacheValid() {
		return cacheValid;
	}

	public void Expression.validateCache() {
		this.cacheValid = true;
	}
	
	public void Expression.invalidateCache() {
		cacheValid = false;
		if (this.getAncestor()!=null) this.getAncestor().invalidateCache();
	}

	public Expression Expression.getAncestor() {
		return ancestor;
	}

	public void Expression.setAncestor(Expression ancestor) {
		this.ancestor = ancestor;
	}

	pointcut changeValue(Expression exp): 
		target(exp) && 
		(
				call(public void Number.setValue(int)) ||
				call(public void Plus.setLeftExpression(Expression)) ||
				call(public void Plus.setRightExpression(Expression))
				);

	after(Expression exp):changeValue(exp) {
		exp.invalidateCache();
	}
	
	pointcut evaluation(Expression exp):
		target(exp) && call(public int Expression.eval());
	
	int around(Expression exp):evaluation(exp) {
		if (!exp.isCacheValid()) {
			int result = proceed(exp);
			exp.setCache(result);
			exp.validateCache();
		}
		return exp.getCache();
	}
	
	pointcut PlusCreation(Plus exp): 
		this(exp) && execution(Plus.new(Expression,Expression));
	
	after(Plus exp) : PlusCreation(exp) {
		exp.getLeftExpression().setAncestor(exp);
		exp.getRightExpression().setAncestor(exp);
	}
}
