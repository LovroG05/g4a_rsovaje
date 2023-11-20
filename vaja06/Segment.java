import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Segment {
	private int stanje;
	private final Pane pane;

	Segment nasl, pred;


	public Segment() {
		pane = new Pane();
		redraw();

		stanje = 0;
		nasl = null;
		pred = null;
	}

	public Segment(Segment pred) {
		pane = new Pane();
		redraw();

		stanje = 0;
		nasl = null;
		this.pred = pred;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
		redraw();
	}

	public int getStanje() {
		return stanje;
	}

	public void overflow() {
		stanje = 0;

		try {
			nasl.up();
		} catch(NullPointerException e) {

		} catch(MOverFlowException e) {
			System.out.println(e);
			nasl.overflow();
		}
	}

	public void underflow() {
		stanje = 9;

		try {
			nasl.down();
		} catch(NullPointerException e) {

		} catch(MUnderFlowException e) {
			System.out.println(e);
			nasl.underflow();
		}
	}

	public void up() throws MOverFlowException {
		Platform.runLater(this::redraw);
		stanje++;

		if(stanje > 9)
			throw new MOverFlowException();
	}

	public void down() throws MUnderFlowException {
		Platform.runLater(this::redraw);
		stanje--;

		if(stanje < 0)
			throw new MUnderFlowException();
	}

	public void setNasl(Segment nasl) {
		this.nasl = nasl;
	}

	public void setPrev(Segment pred) {
		this.pred = pred;
	}

	public Node getNode() {
		return pane;
	}

	private void redraw() {
		pane.getChildren().clear();

		Rectangle a = new Rectangle(10 + 10, 10, 30, 10);
		a.setFill((stanje == 1 || stanje == 4) ? Color.LIGHTGRAY : Color.RED);
		Rectangle b = new Rectangle(10 + 10 + 30, 10 + 10, 10, 30);
		b.setFill((stanje == 5 || stanje == 6) ? Color.LIGHTGRAY : Color.RED);
		Rectangle c = new Rectangle(10 + 10 + 30, 10 + 10 + 30 + 10, 10, 30);
		c.setFill(stanje != 2 ? Color.RED : Color.LIGHTGRAY);
		Rectangle d = new Rectangle(10 + 10, 10 + 10 + 30 + 30 + 10, 30, 10);
		d.setFill((stanje != 1 && stanje != 4 && stanje != 7) ? Color.RED : Color.LIGHTGRAY);
		Rectangle e = new Rectangle(10, 10 + 10 + 30 + 10, 10, 30);
		e.setFill((stanje == 0 || stanje == 2 || stanje == 6 || stanje == 8) ? Color.RED : Color.LIGHTGRAY);
		Rectangle f = new Rectangle(10, 10 + 10, 10, 30);
		f.setFill((stanje != 1 && stanje != 2 && stanje != 3 && stanje != 7) ? Color.RED : Color.LIGHTGRAY);
		Rectangle g = new Rectangle(10 + 10, 10 + 30 + 10, 30, 10);
		g.setFill((stanje != 0 && stanje != 1 && stanje != 7) ? Color.RED : Color.LIGHTGRAY);

		pane.getChildren().addAll(a, b, c, d, e, f, g);
	}

	public String toString() {
		return "" + stanje;
	}
}
