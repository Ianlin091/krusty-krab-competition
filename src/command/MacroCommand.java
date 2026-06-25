package command;

import java.util.ArrayList;

public class MacroCommand extends Command{
	public ArrayList<Command> commands = new ArrayList<>();
	public ArrayList<Command> redolist = new ArrayList<>();
	public ArrayList<Command> undolist = new ArrayList<>();

	public void setcommand(Command c) {
		commands.add(c);
		undolist.add(c);
	}

	public void execute() {
		commands.get(commands.size()-1).execute();
	}

	public void redo() {
		undolist.add(redolist.get(redolist.size() - 1));
		redolist.remove(redolist.size() - 1);
		
		int i = undolist.size() - 1;
		undolist.get(i).redo();
	}

	public void undo() {
		redolist.add(undolist.get(undolist.size() - 1));
		undolist.remove(undolist.size() - 1);

		int i = undolist.size() - 1;
		undolist.get(i).undo();
	}
}
