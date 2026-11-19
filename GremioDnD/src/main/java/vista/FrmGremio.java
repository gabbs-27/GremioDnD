package vista;


public class FrmGremio extends javax.swing.JFrame {


    public FrmGremio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel() {
            private final java.awt.Image fondo = cargarFondo();

            private java.awt.Image cargarFondo() {
                java.net.URL url = FrmGremio.class.getResource("/imagenes/fondo.png");
                return url == null ? null : new javax.swing.ImageIcon(url).getImage();
            }

            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if (fondo != null) {
                    double escala = Math.max((double) getWidth() / fondo.getWidth(null), (double) getHeight() / fondo.getHeight(null));
                    int ancho = (int) (fondo.getWidth(null) * escala);
                    int alto = (int) (fondo.getHeight(null) * escala);
                    g.drawImage(fondo, (getWidth() - ancho) / 2, (getHeight() - alto) / 2, ancho, alto, this);
                }
                g.setColor(new java.awt.Color(0, 0, 0, 120));
                g.fillRect(0, 0, getWidth(), 105);
            }
        };
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlRegistro = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNivel = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        lblPuntosVida = new javax.swing.JLabel();
        txtPuntosVida = new javax.swing.JTextField();
        lblClase = new javax.swing.JLabel();
        cmbClase = new javax.swing.JComboBox<>();
        lblAtributo = new javax.swing.JLabel();
        txtAtributo = new javax.swing.JTextField();
        chkAtributo = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        pnlGremio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGremio = new javax.swing.JTable();
        btnCombate = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        pnlBitacora = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaBitacora = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gremio de Aventureros - Wizards of the Coast");
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(244, 236, 216));

        lblTitulo.setFont(new java.awt.Font("Serif", 1, 28));
        lblTitulo.setForeground(new java.awt.Color(255, 236, 179));
        lblTitulo.setText("GREMIO DE AVENTUREROS");

        lblSubtitulo.setFont(new java.awt.Font("Serif", 2, 14));
        lblSubtitulo.setForeground(new java.awt.Color(240, 230, 210));
        lblSubtitulo.setText("Calabozos y Dragones 5ª Edición");

        pnlRegistro.setBackground(new java.awt.Color(250, 245, 230));
        pnlRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Aventurero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(139, 0, 0)));

        lblNombre.setText("Nombre:");

        txtNombre.setToolTipText("Nombre del héroe");

        lblNivel.setText("Nivel (1-20):");

        txtNivel.setToolTipText("Número entero entre 1 y 20");

        lblPuntosVida.setText("Puntos de vida:");

        txtPuntosVida.setToolTipText("Número entero mayor que 0");

        lblClase.setText("Clase:");

        cmbClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Mago", "Clérigo", "Pícaro" }));

        lblAtributo.setText("Armadura pesada:");

        txtAtributo.setToolTipText("Atributo especial de la clase");

        chkAtributo.setText("Sí");
        chkAtributo.setOpaque(false);

        btnRegistrar.setBackground(new java.awt.Color(139, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Serif", 1, 14));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar Aventurero");
        btnRegistrar.setToolTipText("Agrega el aventurero al gremio");
        btnRegistrar.setFocusPainted(false);

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAtributo)
                            .addComponent(lblClase)
                            .addComponent(lblPuntosVida)
                            .addComponent(lblNivel)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntosVida, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRegistroLayout.createSequentialGroup()
                                .addComponent(txtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chkAtributo))))
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnRegistrar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuntosVida)
                    .addComponent(txtPuntosVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClase)
                    .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAtributo)
                    .addComponent(txtAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAtributo))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlGremio.setBackground(new java.awt.Color(250, 245, 230));
        pnlGremio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "El Gremio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(139, 0, 0)));

        tblGremio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clase", "Nombre", "Nivel", "PV", "Dado de golpe", "Atributo especial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGremio);

        btnCombate.setBackground(new java.awt.Color(139, 0, 0));
        btnCombate.setFont(new java.awt.Font("Serif", 1, 14));
        btnCombate.setForeground(new java.awt.Color(255, 255, 255));
        btnCombate.setText("Simular Combate");
        btnCombate.setToolTipText("Cada aventurero ejecuta su táctica de combate");
        btnCombate.setFocusPainted(false);

        btnReportes.setBackground(new java.awt.Color(184, 134, 11));
        btnReportes.setFont(new java.awt.Font("Serif", 1, 14));
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Ver Reportes");
        btnReportes.setToolTipText("Composición y estadísticas del gremio");
        btnReportes.setFocusPainted(false);

        javax.swing.GroupLayout pnlGremioLayout = new javax.swing.GroupLayout(pnlGremio);
        pnlGremio.setLayout(pnlGremioLayout);
        pnlGremioLayout.setHorizontalGroup(
            pnlGremioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGremioLayout.createSequentialGroup()
                .addGroup(pnlGremioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGremioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGremioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnCombate)
                        .addGap(40, 40, 40)
                        .addComponent(btnReportes)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlGremioLayout.setVerticalGroup(
            pnlGremioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGremioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlGremioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCombate)
                    .addComponent(btnReportes))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnlBitacora.setBackground(new java.awt.Color(250, 245, 230));
        pnlBitacora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bitácora de Combate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 14), new java.awt.Color(139, 0, 0)));

        txaBitacora.setEditable(false);
        txaBitacora.setBackground(new java.awt.Color(255, 250, 240));
        txaBitacora.setColumns(20);
        txaBitacora.setFont(new java.awt.Font("Serif", 0, 14));
        txaBitacora.setLineWrap(true);
        txaBitacora.setRows(5);
        txaBitacora.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaBitacora);

        javax.swing.GroupLayout pnlBitacoraLayout = new javax.swing.GroupLayout(pnlBitacora);
        pnlBitacora.setLayout(pnlBitacoraLayout);
        pnlBitacoraLayout.setHorizontalGroup(
            pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBitacoraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlBitacoraLayout.setVerticalGroup(
            pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBitacoraLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblSubtitulo)
                            .addComponent(lblTitulo)))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFondoLayout.createSequentialGroup()
                                .addComponent(pnlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(pnlGremio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(pnlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(pnlGremio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(pnlBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public javax.swing.JTextField getTxtNombre() {
        return txtNombre;
    }

    public javax.swing.JTextField getTxtNivel() {
        return txtNivel;
    }

    public javax.swing.JTextField getTxtPuntosVida() {
        return txtPuntosVida;
    }

    public javax.swing.JComboBox<String> getCmbClase() {
        return cmbClase;
    }

    public javax.swing.JLabel getLblAtributo() {
        return lblAtributo;
    }

    public javax.swing.JTextField getTxtAtributo() {
        return txtAtributo;
    }

    public javax.swing.JCheckBox getChkAtributo() {
        return chkAtributo;
    }

    public javax.swing.JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public javax.swing.JButton getBtnCombate() {
        return btnCombate;
    }

    public javax.swing.JButton getBtnReportes() {
        return btnReportes;
    }

    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje,
                "Gremio de Aventureros", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje,
                "Datos inválidos", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    public void agregarBitacora(String texto) {
        txaBitacora.append(texto + "\n");
        txaBitacora.setCaretPosition(txaBitacora.getDocument().getLength());
    }

    public void cargarTabla(java.util.List<modelo.Aventurero> lista) {
        javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel(
                new Object[]{"Clase", "Nombre", "Nivel", "PV", "Dado de golpe", "Atributo especial"}, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        for (modelo.Aventurero a : lista) {
            modeloTabla.addRow(new Object[]{a.getNombreClase(), a.getNombre(), a.getNivel(),
                a.getPuntosVida(), a.getDadoGolpe(), a.getAtributoEspecial()});
        }
        tblGremio.setModel(modeloTabla);
        tblGremio.setRowHeight(22);
        tblGremio.getColumnModel().getColumn(5).setPreferredWidth(190);
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtNivel.setText("");
        txtPuntosVida.setText("");
        txtAtributo.setText("");
        chkAtributo.setSelected(false);
        txtNombre.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnCombate;
    private javax.swing.JButton btnReportes;
    private javax.swing.JCheckBox chkAtributo;
    private javax.swing.JComboBox<String> cmbClase;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblPuntosVida;
    private javax.swing.JLabel lblClase;
    private javax.swing.JLabel lblAtributo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JPanel pnlGremio;
    private javax.swing.JPanel pnlBitacora;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGremio;
    private javax.swing.JTextArea txaBitacora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtPuntosVida;
    private javax.swing.JTextField txtAtributo;
    // End of variables declaration//GEN-END:variables
}
