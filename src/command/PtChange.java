package command;

public class PtChange extends Command {
	private Receiver r;
	public PtChange(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.pthat();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();
	}

}
