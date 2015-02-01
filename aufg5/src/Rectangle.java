public class Rectangle {
	protected double height, width;

	public Rectangle(){
		height = 0.0;
		width = 0.0;
	}

	public Rectangle(double height, double width){
		this.height = height;
		this.width = width;
	}

	public double getHeight(){
		return height;
	}

	public double getWidth(){
		return width;
	}

	public void setHeight(double height){
		this.height = height;
	}

	public void setWidth(double width){
		this.width = width;
	}

	public double getPerimeter(){
		return 2*(height + width);
	}

	public double getArea(){
		return height*width;
	}
}

