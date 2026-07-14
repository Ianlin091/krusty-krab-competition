package command;

public class PtChangeHat1 extends Command {
	private Receiver r;
	public PtChangeHat1(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.pthat1();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();
	}

}
