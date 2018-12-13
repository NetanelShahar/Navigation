package GUI;

import Maps.Pixel;

public class Line {
	Pixel start;
	public Pixel end;
	
	public Line(int start_x,int start_y,int end_x,int end_y)
	{
		this.start=new Pixel(start_x, start_y);
		this.end=new Pixel(end_x, end_y);
	}
	public Line(Pixel start , Pixel end)
	{
		this.start = start;
		this.end = end;
	}

	public Pixel getStart() {
		return start;
	}

	public void setStart(Pixel start) {
		this.start = start;
	}

	public Pixel getEnd() {
		return end;
	}

	public void setEnd(Pixel end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return start.toString() + " --> " + end.toString();
	}

}
