package state;

import krusty_krab_competition.KrustyKrab_Controller;

abstract class AbsState extends KrustyKrab_Controller {
	public abstract void execute(StateContext context);
}
