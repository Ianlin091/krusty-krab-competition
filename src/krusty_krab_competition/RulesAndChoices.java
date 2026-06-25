package krusty_krab_competition;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import command.*;
import decorator.*;
import flyweight_observer.FlyweightFactory;
import state.*;
import iterator.*;
import strategy.StrategyContext;

public class RulesAndChoices {
	//start button
	public static ImageIcon image = null, play = null;
	public static ImageIcon game_rules = null;
	public static JLabel sb = null, pt = null,sb_r = null, sb_l = null, pt_r = null, pt_l = null, bg_r = null, bg_l = null, b = null;
	public static JLabel page = null;
	//click
	public static boolean sbsize = false, ptsize = false, sbundo = false, ptundo = false;
	
	//bgClick
	public static String bgpic = "b1";
	
	//timer
	public static Timer count;
	public static int seconds = 3;
	
	//decorator
	Component ptc = new ConcretePt(), sbc = new ConcreteSb();
	Component ptcd, sbcd;
	public static String ptad, sbad, ptupad, sbupad;
	
	
	public void ready() {
		StateStart.label1.setVisible(false);
		//game rules
		game_rules = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/Game_rules.png"));
		game_rules = KrustyKrab_Controller.change(game_rules,0.75);
		page = new JLabel(game_rules);
		page.setBounds(-5, -15, 1090, 800);
		StatePrestart.frame.getLayeredPane().add(page, BorderLayout.CENTER);
    	
        //play button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/play.png"));
        play = KrustyKrab_Controller.change(play, 0.4);
        StateStart.playl = new JLabel(play);
        StateStart.playl.setBounds(700, -65, 400, 300);
        StatePrestart.frame.getLayeredPane().add(StateStart.playl, new Integer(Integer.MAX_VALUE)); 
	}
	
	public void dress() {
		StateStart.playl.setVisible(false);
    	StatePrestart.frame.remove(StateStart.playl);
		//dress
    	game_rules = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/choose.png"));
    	game_rules = KrustyKrab_Controller.change(game_rules,0.75);
    	page.setBounds(-5, -15, 1090, 800);
    	page.setIcon(game_rules);

        //next button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/next.png"));
        play = KrustyKrab_Controller.change(play, 0.2);
        StateStart.dress1 = new JLabel(play);
        StateStart.dress1.setBounds(825, -65, 400, 300);
        StatePrestart.frame.getLayeredPane().add(StateStart.dress1, new Integer(Integer.MAX_VALUE));
        
        //sb 
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/sb.png"));
        play = KrustyKrab_Controller.change(play, 0.5);
        sb = new JLabel(play);
        sb.setBounds(120, 240, 400, 300);
        StatePrestart.frame.getLayeredPane().add(sb, new Integer(Integer.MAX_VALUE));
        //pt 
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/pt.png"));
        play = KrustyKrab_Controller.change(play, 0.5);
        pt = new JLabel(play);
        pt.setBounds(570, 250, 400, 300);
        StatePrestart.frame.getLayeredPane().add(pt, new Integer(Integer.MAX_VALUE));
        
        //sb left button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/left.png"));
        play = KrustyKrab_Controller.change(play, 0.15);
        sb_l = new JLabel(play);
        sb_l.setBounds(135, 600, play.getIconWidth(), play.getIconHeight());
        StatePrestart.frame.getLayeredPane().add(sb_l, new Integer(Integer.MAX_VALUE));
        //sb right button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/right.png"));
        play = KrustyKrab_Controller.change(play, 0.15);
        sb_r = new JLabel(play);
        sb_r.setBounds(470, 598, play.getIconWidth(), play.getIconHeight());
        StatePrestart.frame.getLayeredPane().add(sb_r, new Integer(Integer.MAX_VALUE));
        
        //pt left button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/left.png"));
        play = KrustyKrab_Controller.change(play, 0.15);
        pt_l = new JLabel(play);
        pt_l.setBounds(580, 595, play.getIconWidth(), play.getIconHeight());
        StatePrestart.frame.getLayeredPane().add(pt_l, new Integer(Integer.MAX_VALUE));
        //pt right button
        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/right.png"));
        play = KrustyKrab_Controller.change(play, 0.15);
        pt_r = new JLabel(play);
        pt_r.setBounds(915, 593, play.getIconWidth(), play.getIconHeight());
        StatePrestart.frame.getLayeredPane().add(pt_r, new Integer(Integer.MAX_VALUE));
        
        //click
        MacroCommand sbmc = new MacroCommand();
        MacroCommand ptmc = new MacroCommand();
        Receiver receiver = new Receiver();
        // sb_r
        sb_r.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(sbmc.undolist.size() < 3) {
					if(sbundo) {
						sbmc.redo();
						if(sbmc.redolist.size() == 0) {
							sbundo = false;
						}
					}else if(sbmc.commands.size() == 0) {
						Command c =  new SbChangeHat1(receiver);
						sbmc.setcommand(c);
						sbmc.execute();
					}else if(sbmc.commands.size() == 1) {
						Command c =  new SbChangeHat2(receiver);
						sbmc.setcommand(c);
						sbmc.execute();
					}else if(sbmc.commands.size() == 2) {
						Command c =  new SbChange(receiver);
						sbmc.setcommand(c);
						sbmc.execute();
					}
					if(sbmc.undolist.size() >= 2) {
						sbsize = true;
					}else {
						sbsize = false;
					}
				}
			}
		});
        // sb_l
        sb_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(sbsize) {
					sbmc.undo();
					sbundo = true;
					if(sbmc.undolist.size() < 2) {
						sbsize = false;
					}
				}
			}
		});
        
        // pt_r
        pt_r.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(ptmc.undolist.size() < 3) {
					if(ptundo) {
						ptmc.redo();
						if(ptmc.redolist.size() == 0) {
							ptundo = false;
						}
					}else if(ptmc.commands.size() == 0) {
						Command c =  new PtChangeHat1(receiver);
						ptmc.setcommand(c);
						ptmc.execute();
					}else if(ptmc.commands.size() == 1) {
						Command c =  new PtChangeHat2(receiver);
						ptmc.setcommand(c);
						ptmc.execute();
					}else if(ptmc.commands.size() == 2) {
						Command c =  new PtChange(receiver);
						ptmc.setcommand(c);
						ptmc.execute();
					}
					if(ptmc.undolist.size() >= 2) {
						ptsize = true;
					}
				}
			}
		});
        // pt_l
        pt_l.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(ptsize) {
					ptmc.undo();
					ptundo = true;
					if(ptmc.undolist.size() < 2) {
						ptsize = false;
					}
				}
			}
		});
	}
	
	public void selectbg(boolean selectbgimg) {
		if(selectbgimg) {
			StateStart.dress1.setVisible(false);
	    	StatePrestart.frame.remove(StateStart.dress1);
	    	sb.setVisible(false);
	    	StatePrestart.frame.remove(sb);
			pt.setVisible(false);
	    	StatePrestart.frame.remove(pt);
	    	sb_r.setVisible(false);
	    	StatePrestart.frame.remove(sb_r);
	    	sb_l.setVisible(false);
	    	StatePrestart.frame.remove(sb_l);
	    	pt_r.setVisible(false);
	    	StatePrestart.frame.remove(pt_r);
	    	pt_l.setVisible(false);
	    	StatePrestart.frame.remove(pt_l);
			
			//bg
	    	game_rules = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/bg.png"));
	    	game_rules = KrustyKrab_Controller.change(game_rules,0.75);
	    	page.setBounds(-5, -15, 1090, 800);
	    	page.setIcon(game_rules);
	    	
	        //next button
	        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/next.png"));
	        play = KrustyKrab_Controller.change(play, 0.2);
	        StateStart.bg1 = new JLabel(play);
	        StateStart.bg1.setBounds(800, -65, 400, 300);
	        StatePrestart.frame.getLayeredPane().add(StateStart.bg1, new Integer(Integer.MAX_VALUE));
			
	        //bg
	        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/b1.png"));
	        play = KrustyKrab_Controller.change(play, 0.8);
	        b = new JLabel(play);
	        b.setBounds(-25, -40, play.getIconWidth(), play.getIconHeight());
	        StatePrestart.frame.getLayeredPane().add(b, new Integer(Integer.MAX_VALUE));
	        
	        //bg left button
	        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/left.png"));
	        play = KrustyKrab_Controller.change(play, 0.23);
	        bg_l = new JLabel(play);
	        bg_l.setBounds(120, 525, 400, 300);
	        StatePrestart.frame.getLayeredPane().add(bg_l, new Integer(Integer.MAX_VALUE));
	        //bg right button
	        play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/right.png"));
	        play = KrustyKrab_Controller.change(play, 0.23);
	        bg_r = new JLabel(play);
	        bg_r.setBounds(580, 525, 400, 300);
	        StatePrestart.frame.getLayeredPane().add(bg_r, new Integer(Integer.MAX_VALUE));
	        
	        //Iterator
	        Aggregate ag = new ConcreteAggregate();
	        ag.add("b1");
	        ag.add("b2");
	        ag.add("b3");
	        Iterator it = ag.getIterator();
	        
	        //click
	        // bg_r
	        bg_r.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					bgpic = it.next();
					play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/" + bgpic + ".png"));
			        play = KrustyKrab_Controller.change(play, 0.8);
			        b.setBounds(-25, -40, play.getIconWidth(), play.getIconHeight());
			        b.setIcon(play);
				}
			});
	        // bg_l
	        bg_l.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					bgpic = it.previous();
					play = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/" + bgpic + ".png"));
			        play = KrustyKrab_Controller.change(play, 0.8);
			        b.setBounds(-25, -40, play.getIconWidth(), play.getIconHeight());
			        b.setIcon(play);
				}
			});
		}
	}
	
	public void play() {
		bg_r.setVisible(false);
    	StatePrestart.frame.remove(bg_r);
    	bg_l.setVisible(false);
    	StatePrestart.frame.remove(bg_l);
    	b.setVisible(false);
    	StatePrestart.frame.remove(b);
    	
		//ptDecorator
		if(Receiver.phat.equals("hat1")) {
			ptcd = new CD_PtH1(ptc);
			ptad = ptcd.dressup();
			ptupad = "pt_up_h1";
		}else if(Receiver.phat.equals("hat2")) {
			ptcd = new CD_PtH2(ptc);
			ptad = ptcd.dressup();
			ptupad = "pt_up_h2";
		}else {
			ptad = ptc.dressup();
			ptupad = "pt_up";
		}
		//sbDecorator
		if(Receiver.shat.equals("hat1")) {
			sbcd = new CD_SbH1(sbc);
			sbad = sbcd.dressup();
			sbupad = "sb_up_h1";
		}else if(Receiver.shat.equals("hat2")) {
			sbcd = new CD_SbH2(sbc);
			sbad = sbcd.dressup();
			sbupad = "sb_up_h2";
		}else {
			sbad = sbc.dressup();
			sbupad = "sb_up";
		}
		//ptLabel
		image = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + ptad + "/00.png"));
		image = KrustyKrab_Controller.change(image, 0.9);
		JLabel ptLabel = FlyweightFactory.getCharacterLabel("pt_ord", 460, 340);
		ptLabel.setIcon(image);
		//sbLabel
		image = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + sbad + "/00.png"));
		image = KrustyKrab_Controller.change(image, 0.9);
		JLabel sbLabel = FlyweightFactory.getCharacterLabel("sb_ord", -50, 350);
		sbLabel.setIcon(image);
		//background
		image = new ImageIcon(getClass().getResource("/krusty_krab_competition/page/" + bgpic + "_.png"));
		image = KrustyKrab_Controller.change(image,0.75);
        KrustyKrab_Controller.bgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        KrustyKrab_Controller.bgLabel.setIcon(image); 
		
		//cancelButton
		StateStart.bg1.setVisible(false);
    	StatePrestart.frame.remove(StateStart.bg1);
    	
    	//show3 2 1
    	image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/33.png")); 
    	image = KrustyKrab_Controller.change(image,0.3);
    	page.setIcon(image);
        
        //timer
        count = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	seconds--;
                if(seconds == 2) {
                	image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/22.png")); 
                	image = KrustyKrab_Controller.change(image,0.3);
                	page.setIcon(image);
                    //imageLabel.setIcon(images[1]);
                }else if(seconds == 1) {
                	image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/11.png")); 
                	image = KrustyKrab_Controller.change(image,0.3);
                	page.setIcon(image);
                    //imageLabel.setIcon(images[2]);
                }else if(seconds == 0) {
                	image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/start.png")); 
                	image = KrustyKrab_Controller.change(image,0.25);
                	page.setIcon(image);
                    //imageLabel.setIcon(images[3]);
                }
                
                if (seconds < 0) {
                	count.stop();
                	page.setVisible(false);
                	StatePrestart.frame.remove(page);
    				
    				//Game timer start
                	StateStart.timer.start();
                	KrustyKrab_Controller.pt_signlight();
                	KrustyKrab_Controller.sb_signlight();
    				
    				//keyPress();
    				StrategyContext.strategyMethod();
                }
            }
        });
        count.start();
	}
}
