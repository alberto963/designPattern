package example.designPattern.command.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
	private Component target;

	public ExitAction(String name, Icon icon, Component t) {
		putValue(Action.NAME, name);
		putValue(Action.SMALL_ICON, icon);
		putValue(Action.SHORT_DESCRIPTION, name + " the program");
		
		target = t;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		int answer = JOptionPane.showConfirmDialog(target,
				"Are you sure you want to exit? ", "Confirmation",
				JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}

@SuppressWarnings("serial")
class SubmitAction extends AbstractAction {
	private Component target;

	public SubmitAction(String name, Icon icon, Component t) {
		putValue(Action.NAME, name);
		putValue(Action.SMALL_ICON, icon);
		putValue(Action.SHORT_DESCRIPTION, name + " the program");
		target = t;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(target, "submit action clicked ");
	}
}

@SuppressWarnings("serial")
class Test extends JFrame {
	Test() {
		Action ea = new ExitAction("Exit", null, this);
		Action sa = new SubmitAction("Submit", new ImageIcon(), this);

		/**
		 * JMenu
		 */
		final JMenuBar jbr = new JMenuBar();
		JMenu dropmenu = new JMenu("File");
		JMenuItem submitmenu = new JMenuItem(sa);
		JMenuItem exitmenu = new JMenuItem(ea);
		dropmenu.add(submitmenu);
		dropmenu.add(exitmenu);
		jbr.add(dropmenu);
		setJMenuBar(jbr);

		/**
		 * JPopup
		 */
		final JPopupMenu jpm = new JPopupMenu("PopMenu");
		jpm.add(sa);
		jpm.add(ea);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			private void showPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					jpm.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		/**
		 * JButton
		 */
		JPanel jp = new JPanel();
		JButton subbtn = new JButton(sa);
		JButton exitbtn = new JButton(ea);
		jp.add(subbtn);
		jp.add(exitbtn);
		Container con = getContentPane();
		con.add(jp, "South");

		/**
		 * Frame
		 */
		setTitle("Command pattern example");
		setIconImage(new ImageIcon("earth.gif").getImage());
		setSize(400, 200);
		setVisible(true);

	}

	public static void main(String[] args) {
		try {
			new Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
