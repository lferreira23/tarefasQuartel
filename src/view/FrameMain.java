package view;

/**
 * FrameMain usado para a escolha Entre Cadastrar e Buscar Militar, é também onde fica a ArrayList Para manter sempre Aberto.
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class FrameMain extends javax.swing.JFrame {
    
    public FrameMain() {
        initComponents();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               FrameLogin frameLogin = new FrameLogin(FrameMain.this);
               frameLogin.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbExercitoLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmMilitar = new javax.swing.JMenu();
        jmCadastrar = new javax.swing.JMenuItem();
        jmBuscar = new javax.swing.JMenuItem();
        jmListar = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(164, 199, 158));
        jPanel1.setToolTipText("");

        lbExercitoLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExercitoLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exercito_Brasileiro_Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(lbExercitoLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbExercitoLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jmMilitar.setBackground(new java.awt.Color(164, 199, 158));
        jmMilitar.setText("Militar");

        jmCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmCadastrar.setBackground(new java.awt.Color(164, 199, 158));
        jmCadastrar.setText("Cadastro");
        jmCadastrar.setActionCommand("Cadastar");
        jmCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastrarActionPerformed(evt);
            }
        });
        jmMilitar.add(jmCadastrar);

        jmBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmBuscar.setBackground(new java.awt.Color(164, 199, 158));
        jmBuscar.setText("Tarefas");
        jmBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBuscarActionPerformed(evt);
            }
        });
        jmMilitar.add(jmBuscar);

        jmListar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmListar.setText("Militares");
        jmListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListarActionPerformed(evt);
            }
        });
        jmMilitar.add(jmListar);

        jmSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jmMilitar.add(jmSair);

        jMenuBar1.add(jmMilitar);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //passo o FrameCadastro como this para se referir ao conteudo do Frame Menu.
    private void jmCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastrarActionPerformed
        FrameCadastro frameCadastro = new FrameCadastro(this);
        frameCadastro.setVisible(true);
    }//GEN-LAST:event_jmCadastrarActionPerformed
   
    private void jmBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBuscarActionPerformed
       FrameTarefas framebuscar = new FrameTarefas(this);
       framebuscar.setVisible(true);
    }//GEN-LAST:event_jmBuscarActionPerformed

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmSairActionPerformed

    private void jmListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListarActionPerformed
       FrameListagem frameListagem = new FrameListagem();
       frameListagem.setVisible(true);
    }//GEN-LAST:event_jmListarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmBuscar;
    private javax.swing.JMenuItem jmCadastrar;
    private javax.swing.JMenuItem jmListar;
    private javax.swing.JMenu jmMilitar;
    private javax.swing.JMenuItem jmSair;
    private javax.swing.JLabel lbExercitoLogo;
    // End of variables declaration//GEN-END:variables
}
