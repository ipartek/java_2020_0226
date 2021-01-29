package com.ipartek.formacion.spring.uf2177_1.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.spring.uf2177_1.accesodatos.MedicamentoDao;
import com.ipartek.formacion.spring.uf2177_1.accesodatos.MedicamentoDaoJdbc;
import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;

public class PresentacionSwing {

	private MedicamentoDao dao = MedicamentoDaoJdbc.getInstancia();
	private Long idSeleccionado = null;
	
	private JFrame frame;
	private JTextField tfEjemplo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private DefaultTableModel modelo;
	private JTextField tfNombre;
	private JTextField tfReferencia;
	private JTextField tfPrecio;
	private JTable table;

	/**
	 * Create the application.
	 */
	public PresentacionSwing() {
		initialize();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nombre", "Referencia", "Precio" });

		table.setModel(modelo);

		cargarTabla();

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow != -1) {
					System.out.println("Selected row: " + selectedRow);
					System.out.println("ValueAt:      " + table.getValueAt(selectedRow, 0).toString());

					tfNombre.setText(table.getValueAt(selectedRow, 1).toString());
					tfReferencia.setText(table.getValueAt(selectedRow, 2).toString());
					tfPrecio.setText(table.getValueAt(selectedRow, 3).toString());
					
					idSeleccionado = (Long)table.getValueAt(selectedRow, 0);
				} else {
					idSeleccionado = null;
				}
			}
		});
	}

	private void cargarTabla() {
		modelo.setRowCount(0);

		modelo.addRow(new Object[] { "Id", "Nombre", "Referencia", "Precio" });

		for (Medicamento medicamento : dao.obtenerTodos()) {

			modelo.addRow(new Object[] { medicamento.getId(), medicamento.getNombre(), medicamento.getReferencia(),
					medicamento.getPrecio() });
		}
	}

	private void btnSaludarClick(JLabel lblResultado) {
		JOptionPane.showMessageDialog(frame, "Prueba de botón");
		lblResultado.setText("Hola " + tfEjemplo.getText());
	}

	private void btnAceptarClick() {
		Medicamento medicamento = new Medicamento(null, tfReferencia.getText(), tfNombre.getText(),
				new BigDecimal(tfPrecio.getText()));

		if(idSeleccionado != null) {
			//dao.modificar(medicamento);
			System.out.println("dao.modificar(" + medicamento + ")");
		} else {
			dao.agregar(medicamento);
		}

		cargarTabla();
	}

	private void btnBorrarClick() {
		dao.borrar(tfReferencia.getText());

		cargarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(2000, 100, 878, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pSaludar = new JPanel();
		frame.getContentPane().add(pSaludar, BorderLayout.SOUTH);

		JLabel lblNombre = new JLabel("Nombre");
		pSaludar.add(lblNombre);

		tfEjemplo = new JTextField();
		pSaludar.add(tfEjemplo);
		tfEjemplo.setColumns(10);

		JLabel lblResultado = new JLabel("  ");
		pSaludar.add(lblResultado);

		JButton btnSaludar = new JButton("Saludar");
		pSaludar.add(btnSaludar);

		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaludarClick(lblResultado);
			}
		});

		JPanel pFormulario = new JPanel();
		frame.getContentPane().add(pFormulario, BorderLayout.NORTH);
		pFormulario.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Nombre");
		pFormulario.add(lblNewLabel);

		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		pFormulario.add(tfNombre);

		JLabel lblNewLabel_1 = new JLabel("Referencia");
		pFormulario.add(lblNewLabel_1);

		tfReferencia = new JTextField();
		tfReferencia.setColumns(10);
		pFormulario.add(tfReferencia);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		pFormulario.add(lblNewLabel_2);

		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		pFormulario.add(tfPrecio);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptarClick();
			}
		});
		pFormulario.add(btnAceptar);

		JButton btnBorrar = new JButton("Borrar Ref.");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrarClick();
			}
		});
		pFormulario.add(btnBorrar);

		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);

	}
}
