import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ScreenClick extends MouseAdapter {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			TitlePage title = new TitlePage();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
