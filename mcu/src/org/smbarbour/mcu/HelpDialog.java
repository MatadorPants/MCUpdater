package org.smbarbour.mcu;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.smbarbour.mcu.util.MCUpdater;
import javax.swing.ScrollPaneConstants;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3323218282357979241L;

	/**
	 * Create the dialog.
	 * @param window 
	 */
	public HelpDialog(MainForm window) {
		setTitle("MCUpdater Help");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextPane helpWindow = new JTextPane();
		helpWindow.setEditable(false);
		helpWindow.setContentType("text/html");
		helpWindow.addHyperlinkListener(new HyperlinkListener(){

			@Override
			public void hyperlinkUpdate(HyperlinkEvent he) {
				if (he.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					try {
						MCUpdater.openLink(he.getURL().toURI());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});

		scrollPane.setViewportView(helpWindow);
		
		helpWindow.setText(generateHelpPage());
	}

	private String generateHelpPage() {
		StringBuilder contents = new StringBuilder();
		
		contents.append("<HTML><BODY>");
		contents.append("This is where the contents would appear.");
		contents.append("</BODY></HTML>");
		
		return contents.toString();
	}

}
