class TextEditor
{
	private StringBuilder sb; // Stores text
	private int cur; // pointer index

	public TextEditor()
	{
		sb = new StringBuilder();
		cur = 0;
	}

	public void addText(String text)
	{
		sb.insert(cur,text);
		cur += text.length(); // Shift pointer to the right of added text
	}

	public int deleteText(int k)
	{
		int l = Math.max(0,cur-k);
		int r = cur;
		sb.delete(l,r);
		cur = l; // Shift pointer to the left of deleted text
		return r-l;
	}

	public String cursorLeft(int k)
	{
		cur =  Math.max(0,cur-k); // Maximum text present on the left

		return string10CharToLeft();
	}

	public String cursorRight(int k)
	{
		cur = Math.min(sb.length(),cur+k); // Maximum text present on the right

		return string10CharToLeft();
	}

	private String string10CharToLeft(){
		int left = Math.max(0,cur-10);
		return sb.substring(left,cur);
	}
}