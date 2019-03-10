package br.com.fiap.design;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBO;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBOResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class design {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			design window = new design();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			
			
			/* pega O TesteConsulta e cola aqui, para fazer consulta na
			 *janela com o botao, e é necessario um try catch
			 *e cuidado com o server
			 *obs: Rodar o providerWs para testar o servidor
			 */
			public void widgetSelected(SelectionEvent e) {
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultaBO consultar = new ConsultaBO();
					consultar.setCodProd(Integer.parseInt(text.getText()));
					ConsultaBOResponse response = stub.consultaBO(consultar);
					
					ProdutoTO produto = response.get_return();
					MessageDialog.openInformation(null, "Camisa Encontrada", produto.getDescricao());
				} catch (Exception e2) {
					MessageDialog.openInformation(null, "Camisa Encontrada", "ERRO");
					
				}
				
			
			}
		});
		
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI Semilight", 9, SWT.BOLD));
		btnNewButton.setBounds(179, 144, 75, 25);
		btnNewButton.setText("New Button");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(81, 34, 76, 21);

	}
}
