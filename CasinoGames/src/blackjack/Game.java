package blackjack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class Game {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Game window = new Game();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(985, 779);
		shell.setText("SWT Application");
		Display display = Display.getDefault();
		
		Label lblDealerCard1 = new Label(shell, SWT.NONE);
		lblDealerCard1.setBounds(276, 106, 55, 15);
		
		Label lblDealerCard2 = new Label(shell, SWT.NONE);
		lblDealerCard2.setBounds(472, 106, 55, 15);
		
		Label lblPlayersHand = new Label(shell, SWT.NONE);
		lblPlayersHand.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblPlayersHand.setBounds(324, 656, 55, 15);
		lblPlayersHand.setText("Players Hand:");
		lblPlayersHand.pack();
		
		Label lblDealersHand = new Label(shell, SWT.NONE);
		lblDealersHand.setAlignment(SWT.CENTER);
		lblDealersHand.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblDealersHand.setBounds(324, 10, 55, 15);
		lblDealersHand.setText("Dealers Hand:");
		lblDealersHand.pack();
		
		Label lblPlayerCard1 = new Label(shell, SWT.NONE);
		lblPlayerCard1.setBounds(276, 390, 55, 15);
		
		Label lblPlayerCard2 = new Label(shell, SWT.NONE);
		lblPlayerCard2.setBounds(472, 390, 55, 15);
		lblPlayerCard2.setText("");
		Button btnPlay = new Button(shell, SWT.NONE);
		btnPlay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblDealerCard1.setImage(new Image(display, "img/2C.png"));
				lblDealerCard2.setImage(new Image(display, "img/BACK.png"));
				lblPlayerCard1.setImage(new Image(display, "img/10H.png"));
				lblPlayerCard2.setImage(new Image(display, "img/AS.png"));
				lblPlayerCard1.pack();
				lblPlayerCard2.pack();
				lblDealerCard1.pack();
				lblDealerCard2.pack();
				
			}
		});
		btnPlay.setBounds(666, 287, 75, 25);
		btnPlay.setText("Play");
		
		
		
		
		
		
		
		
		
		

	}
}
