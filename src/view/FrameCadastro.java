package view;


import controller.MilitarController;
import controller.Utils;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Militar;
import model.EnumPatente;
import model.EnumTarefa;

/**
 * Frame para o Cadastro do Militar e Edição do mesmo
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class FrameCadastro extends javax.swing.JFrame {
    FrameMain parentFrame = null;
    Militar militarAtual = null;
    
    private ArrayList<javax.swing.JRadioButton> radioButtons = new ArrayList<>();
    private ArrayList<javax.swing.JCheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<javax.swing.JComponent> notNull = new ArrayList<>();
   
    private void initComponentLists() {
        radioButtons.add(rbSoldado);
        radioButtons.add(rbCabo);
        radioButtons.add(rbTerceiroSargento);
        radioButtons.add(rbSegundoSargento);
        radioButtons.add(rbPrimeiroSargento);
        radioButtons.add(rbSubtenente);
        radioButtons.add(rbAspirante);
        radioButtons.add(rbSegundoTenente);
        radioButtons.add(rbPrimeiroTenente);
        radioButtons.add(rbCapitao);
        
        checkBoxes.add(chkDescascarBatatas);
        checkBoxes.add(chkLimparBanheiro);
        checkBoxes.add(chkLimparCozinha);
        checkBoxes.add(chkCozinharAlmoco);
        checkBoxes.add(chkCozinharJanta);
        checkBoxes.add(chkAlimentarCavalos);
        checkBoxes.add(chkLimparEstabulos);
        checkBoxes.add(chkRecarregar);
        checkBoxes.add(chkTrocarEncanamento);
        checkBoxes.add(chkLevantarBandeira);
        
        notNull.add(tfNome);
        notNull.add(ftfCpf);
        notNull.add(ftfRg);
        notNull.add(ftfNascimento);
    }
    
   private void updateCampoIdade() {
        String nascimento = ftfNascimento.getText();
        Date date = Utils.stringToDate(nascimento);
        int idade = Utils.getAgeInYears(date);
        tfIdade.setText(""+idade);
    }
    
    private boolean validarCPF(String cpf) {
        String rawCpf = cpf.replaceAll("[-.]","");
        return Utils.validarCPF(rawCpf);
    }
    
    private boolean validarCampos() {
        boolean result = true;
        for(javax.swing.JComponent c : notNull) {
            if(c instanceof javax.swing.JFormattedTextField) {
                String value = ((javax.swing.JFormattedTextField)c).getText();
                value = value.replaceAll("[-./]", "");
                if(value == null || value.trim().equals("")) {
                    result = false;
                    break;
                }
            }
            else if(c instanceof javax.swing.JTextField) {
                String text = ((javax.swing.JTextField)c).getText();
                if(text.trim().equals("")) {
                    result = false;
                    break;
                }               
            }
        }
        
        if(buttonGroup1.getSelection() == null)
            result = false;
        if(buttonGroup2.getSelection() == null)
            result = false;
        
        if(cbEstado.getSelectedIndex() == -1)
            result = false;
        
        if(!result) {
            JOptionPane.showMessageDialog(null, "Campos com * devem ser preenchidos obrigatoriamente", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        String cpf = ftfCpf.getText();
        if(!validarCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido", "Aviso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return result;
    }
    
    private void limparTarefas() {
        for(javax.swing.JCheckBox c : checkBoxes) {
            c.setSelected(false);
            c.setEnabled(false);
        }
    }
    
    //limpa os campos de cadastro 
    private void limparCampos(){
        tfCodigo.setText("");  
        tfNome.setText("");
        ftfCpf.setText("");
        ftfRg.setText("");
        ftfNascimento.setText("");
        tfIdade.setText("");
        cbEstado.setSelectedIndex(-1);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        limparTarefas();
        btEditarMilitar.setEnabled(false);
        btExcluirMilitar.setEnabled(false);
    }
    
//Função para Salvar o Militar no Array e também verifica se o Codigo do militar ja existe.
    private void copyCamposToMilitar(Militar militar) {
        
        militar.setNome(tfNome.getText());
        militar.setCpf(ftfCpf.getText());
        militar.setRg(ftfRg.getText());
        militar.setEstado((String) cbEstado.getSelectedItem());
        militar.setSexo(rbMasculino.isSelected()?'M':'F');
        militar.setNascimento(Utils.stringToDate(ftfNascimento.getText()));
        for(int i = 0; i < radioButtons.size(); i++) {
            if(radioButtons.get(i).isSelected()) {
                militar.setPatente(EnumPatente.values()[i]);
                break;
            }
        }

        for(int i = 0; i < checkBoxes.size(); i++) {
            javax.swing.JCheckBox chk = checkBoxes.get(i);
            if(chk.isEnabled())
                militar.setAtividade(EnumTarefa.values()[i], chk.isSelected());
        }
    }
    
    private void setCamposFromMilitar(Militar militar) {
        tfCodigo.setText("" + militar.getCodigo());
        tfNome.setText(militar.getNome());
        ftfCpf.setText(militar.getCpf());
        ftfRg.setText(militar.getRg());
        cbEstado.setSelectedItem(militar.getEstado());
        rbMasculino.setSelected(militar.getSexo() == 'M');
        rbFeminino.setSelected(militar.getSexo() == 'F');
        ftfNascimento.setText(Utils.dateToString(militar.getNascimento()));
        radioButtons.get(militar.getPatente().ordinal()).setSelected(true);
        updateCampoIdade();
        for(int i = 0; i < checkBoxes.size(); i++) {
            if(checkBoxes.get(i).isEnabled())
                checkBoxes.get(i).setSelected(militar.fazAtividade(EnumTarefa.values()[i]));
        }
    }
    
    public FrameCadastro(FrameMain parentFrame){
        initComponents();
        initComponentLists();
        setLocationRelativeTo(null);
        this.parentFrame = parentFrame;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelDadosMilitar = new javax.swing.JPanel();
        LbCodigo = new javax.swing.JLabel();
        LbNome = new javax.swing.JLabel();
        LbSexo = new javax.swing.JLabel();
        LbCpf = new javax.swing.JLabel();
        LbRg = new javax.swing.JLabel();
        LbNascimento = new javax.swing.JLabel();
        LbIdade = new javax.swing.JLabel();
        LbEstado = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfRg = new javax.swing.JFormattedTextField();
        ftfNascimento = new javax.swing.JFormattedTextField();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        cbEstado = new javax.swing.JComboBox<>();
        lbSubtenente = new javax.swing.JLabel();
        rbSoldado = new javax.swing.JRadioButton();
        lbAspirante = new javax.swing.JLabel();
        rbCabo = new javax.swing.JRadioButton();
        lbCabo = new javax.swing.JLabel();
        lbTerceiroSargento = new javax.swing.JLabel();
        rbTerceiroSargento = new javax.swing.JRadioButton();
        lbSoldado = new javax.swing.JLabel();
        rbSegundoSargento = new javax.swing.JRadioButton();
        lbSegundoTenente = new javax.swing.JLabel();
        lbSegundoSargento = new javax.swing.JLabel();
        rbSubtenente = new javax.swing.JRadioButton();
        rbAspirante = new javax.swing.JRadioButton();
        rbSegundoTenente = new javax.swing.JRadioButton();
        lbPrimeiroSargento = new javax.swing.JLabel();
        rbPrimeiroSargento = new javax.swing.JRadioButton();
        lbPrimeiroTenente = new javax.swing.JLabel();
        rbPrimeiroTenente = new javax.swing.JRadioButton();
        lbCapitao = new javax.swing.JLabel();
        rbCapitao = new javax.swing.JRadioButton();
        LbSexo1 = new javax.swing.JLabel();
        tfIdade = new javax.swing.JTextField();
        panelTarefas = new javax.swing.JPanel();
        chkDescascarBatatas = new javax.swing.JCheckBox();
        chkLimparBanheiro = new javax.swing.JCheckBox();
        chkLimparCozinha = new javax.swing.JCheckBox();
        chkCozinharAlmoco = new javax.swing.JCheckBox();
        chkCozinharJanta = new javax.swing.JCheckBox();
        chkAlimentarCavalos = new javax.swing.JCheckBox();
        chkLimparEstabulos = new javax.swing.JCheckBox();
        chkRecarregar = new javax.swing.JCheckBox();
        chkTrocarEncanamento = new javax.swing.JCheckBox();
        chkLevantarBandeira = new javax.swing.JCheckBox();
        panelOpcoes = new javax.swing.JPanel();
        btCadastrarMilitar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btEditarMilitar = new javax.swing.JButton();
        btBuscarMilitar = new javax.swing.JButton();
        btExcluirMilitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Militar");
        setBackground(new java.awt.Color(0, 102, 0));

        panelDadosMilitar.setBackground(new java.awt.Color(164, 199, 158));
        panelDadosMilitar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dados do Militar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft JhengHei Light", 1, 13), new java.awt.Color(51, 102, 0))); // NOI18N

        LbCodigo.setText("Código:");

        LbNome.setText("Nome*");

        LbSexo.setText("Sexo*");

        LbCpf.setText("CPF*");

        LbRg.setText("RG*");

        LbNascimento.setText("Nascimento*");

        LbIdade.setText("Idade:");

        LbEstado.setText("Estado*");

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftfNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfNascimentoFocusLost(evt);
            }
        });

        buttonGroup2.add(rbMasculino);
        rbMasculino.setText("Masculino");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbFeminino);
        rbFeminino.setText("Feminino");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "RJ", "MG", "ES", "DF" }));

        lbSubtenente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_06_Subtenente.png"))); // NOI18N

        buttonGroup1.add(rbSoldado);
        rbSoldado.setText("Soldado");
        rbSoldado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSoldadoItemStateChanged(evt);
            }
        });
        rbSoldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSoldadoActionPerformed(evt);
            }
        });

        lbAspirante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_07_Aspirante.png"))); // NOI18N

        buttonGroup1.add(rbCabo);
        rbCabo.setText("Cabo");
        rbCabo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCaboItemStateChanged(evt);
            }
        });

        lbCabo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_02_Cabo.png"))); // NOI18N

        lbTerceiroSargento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_03_Terceiro-Sargento.png"))); // NOI18N

        buttonGroup1.add(rbTerceiroSargento);
        rbTerceiroSargento.setText("3º Sargento");
        rbTerceiroSargento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbTerceiroSargentoItemStateChanged(evt);
            }
        });

        lbSoldado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_01_Soldado.png"))); // NOI18N

        buttonGroup1.add(rbSegundoSargento);
        rbSegundoSargento.setText("2º Sargento");
        rbSegundoSargento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSegundoSargentoItemStateChanged(evt);
            }
        });

        lbSegundoTenente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_08_Segundo-Tenente.png"))); // NOI18N

        lbSegundoSargento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_04_Segundo-Sargento.png"))); // NOI18N

        buttonGroup1.add(rbSubtenente);
        rbSubtenente.setText("Subtenente");
        rbSubtenente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSubtenenteItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbAspirante);
        rbAspirante.setText("Aspirante");
        rbAspirante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbAspiranteItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbSegundoTenente);
        rbSegundoTenente.setText("2º Tenente");
        rbSegundoTenente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSegundoTenenteItemStateChanged(evt);
            }
        });

        lbPrimeiroSargento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_05_Primeiro-Sargento.png"))); // NOI18N

        buttonGroup1.add(rbPrimeiroSargento);
        rbPrimeiroSargento.setText("1º Sargento");
        rbPrimeiroSargento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPrimeiroSargentoItemStateChanged(evt);
            }
        });

        lbPrimeiroTenente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_09_Primeiro-Tenente.png"))); // NOI18N

        buttonGroup1.add(rbPrimeiroTenente);
        rbPrimeiroTenente.setText("1º Tenente");
        rbPrimeiroTenente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPrimeiroTenenteItemStateChanged(evt);
            }
        });

        lbCapitao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_10_Capitão.png"))); // NOI18N

        buttonGroup1.add(rbCapitao);
        rbCapitao.setText("Capitão");
        rbCapitao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCapitaoItemStateChanged(evt);
            }
        });

        LbSexo1.setText("Patente*");

        tfIdade.setEnabled(false);
        tfIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDadosMilitarLayout = new javax.swing.GroupLayout(panelDadosMilitar);
        panelDadosMilitar.setLayout(panelDadosMilitarLayout);
        panelDadosMilitarLayout.setHorizontalGroup(
            panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSoldado)
                                    .addComponent(rbSoldado)
                                    .addComponent(lbSubtenente)
                                    .addComponent(rbSubtenente))
                                .addGap(18, 18, 18)
                                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCabo)
                                    .addComponent(rbCabo)
                                    .addComponent(lbAspirante)
                                    .addComponent(rbAspirante))
                                .addGap(18, 18, 18)
                                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTerceiroSargento)
                                    .addComponent(rbTerceiroSargento)
                                    .addComponent(lbSegundoTenente)
                                    .addComponent(rbSegundoTenente)))
                            .addComponent(LbSexo1))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSegundoSargento)
                            .addComponent(rbSegundoSargento)
                            .addComponent(lbPrimeiroTenente)
                            .addComponent(rbPrimeiroTenente))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrimeiroSargento)
                            .addComponent(rbPrimeiroSargento)
                            .addComponent(lbCapitao)
                            .addComponent(rbCapitao)))
                    .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbNome)
                                    .addComponent(LbCodigo))
                                .addGap(3, 3, 3)
                                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(tfCodigo))))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbRg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                                .addComponent(LbIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfIdade)))))
                .addContainerGap())
        );
        panelDadosMilitarLayout.setVerticalGroup(
            panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbCodigo)
                    .addComponent(LbCpf)
                    .addComponent(LbIdade)
                    .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNome)
                    .addComponent(LbRg)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSexo)
                    .addComponent(LbNascimento)
                    .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPrimeiroSargento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTerceiroSargento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbCabo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDadosMilitarLayout.createSequentialGroup()
                            .addComponent(LbSexo1)
                            .addGap(13, 13, 13)
                            .addComponent(lbSoldado))
                        .addComponent(lbSegundoSargento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rbSoldado)
                    .addComponent(rbCabo)
                    .addComponent(rbTerceiroSargento)
                    .addComponent(rbSegundoSargento)
                    .addComponent(rbPrimeiroSargento))
                .addGap(18, 18, 18)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbSubtenente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSegundoTenente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPrimeiroTenente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCapitao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosMilitarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rbSubtenente)
                    .addComponent(rbAspirante)
                    .addComponent(rbSegundoTenente)
                    .addComponent(rbPrimeiroTenente)
                    .addComponent(rbCapitao))
                .addContainerGap())
        );

        panelTarefas.setBackground(new java.awt.Color(164, 199, 158));
        panelTarefas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Quadro de Tarefas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 102, 0))); // NOI18N

        chkDescascarBatatas.setText("Descascar Batatas");
        chkDescascarBatatas.setEnabled(false);

        chkLimparBanheiro.setText("Limpar Banheiro");
        chkLimparBanheiro.setEnabled(false);

        chkLimparCozinha.setText("Limpar Cozinha");
        chkLimparCozinha.setEnabled(false);

        chkCozinharAlmoco.setText("Cozinhar almoço");
        chkCozinharAlmoco.setEnabled(false);

        chkCozinharJanta.setText("Cozinhar Janta");
        chkCozinharJanta.setEnabled(false);

        chkAlimentarCavalos.setText("Alimentar Cavalos");
        chkAlimentarCavalos.setEnabled(false);

        chkLimparEstabulos.setText("Limpar Estabulos");
        chkLimparEstabulos.setEnabled(false);

        chkRecarregar.setText("Recarregar Armamento");
        chkRecarregar.setEnabled(false);

        chkTrocarEncanamento.setText("Trocar encanamento");
        chkTrocarEncanamento.setEnabled(false);

        chkLevantarBandeira.setText("Levantar Bandeira");
        chkLevantarBandeira.setEnabled(false);

        javax.swing.GroupLayout panelTarefasLayout = new javax.swing.GroupLayout(panelTarefas);
        panelTarefas.setLayout(panelTarefasLayout);
        panelTarefasLayout.setHorizontalGroup(
            panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkDescascarBatatas)
                    .addComponent(chkLimparBanheiro)
                    .addComponent(chkCozinharAlmoco)
                    .addComponent(chkLimparCozinha))
                .addGap(59, 59, 59)
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkLimparEstabulos)
                    .addGroup(panelTarefasLayout.createSequentialGroup()
                        .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkCozinharJanta)
                            .addComponent(chkAlimentarCavalos))
                        .addGap(43, 43, 43)
                        .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTrocarEncanamento)
                            .addComponent(chkLevantarBandeira)))
                    .addComponent(chkRecarregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTarefasLayout.setVerticalGroup(
            panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarefasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkDescascarBatatas)
                    .addComponent(chkCozinharJanta)
                    .addComponent(chkTrocarEncanamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkLimparBanheiro)
                    .addComponent(chkAlimentarCavalos)
                    .addComponent(chkLevantarBandeira))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLimparCozinha)
                    .addComponent(chkLimparEstabulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(chkCozinharAlmoco)
                    .addComponent(chkRecarregar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelOpcoes.setBackground(new java.awt.Color(164, 199, 158));
        panelOpcoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 0)));

        btCadastrarMilitar.setText("Cadastrar ");
        btCadastrarMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarMilitarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btEditarMilitar.setText("Editar");
        btEditarMilitar.setEnabled(false);
        btEditarMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarMilitarActionPerformed(evt);
            }
        });

        btBuscarMilitar.setText("Buscar");
        btBuscarMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarMilitarActionPerformed(evt);
            }
        });

        btExcluirMilitar.setText("Excluir");
        btExcluirMilitar.setEnabled(false);
        btExcluirMilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirMilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcoesLayout = new javax.swing.GroupLayout(panelOpcoes);
        panelOpcoes.setLayout(panelOpcoesLayout);
        panelOpcoesLayout.setHorizontalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCadastrarMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBuscarMilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEditarMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluirMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOpcoesLayout.setVerticalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditarMilitar)
                    .addComponent(btCadastrarMilitar)
                    .addComponent(btBuscarMilitar)
                    .addComponent(btVoltar)
                    .addComponent(btExcluirMilitar))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDadosMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDadosMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDadosMilitar.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
     //Metodo que Cadastra o Militar Inteiro.
    private void btCadastrarMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarMilitarActionPerformed
        if(validarCampos()) {
            Militar militar = new Militar();
            copyCamposToMilitar(militar);
            MilitarController.CadastrarMilitar(militar);
            limparCampos();
        }
    }//GEN-LAST:event_btCadastrarMilitarActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed

    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
       dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

       //Botão editar que abre alguns campos para edição
    private void btEditarMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarMilitarActionPerformed
      if(militarAtual != null) {
          if(validarCampos()) {
              copyCamposToMilitar(militarAtual);
              MilitarController.alterarMilitar(militarAtual);
          }
      }
    }//GEN-LAST:event_btEditarMilitarActionPerformed

    
    //Botão para Buscar Militar.
    private void btBuscarMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarMilitarActionPerformed
        String codigoStr = tfCodigo.getText();
        String cpf = ftfCpf.getText();
        String rg = ftfRg.getText();
        String estado = (String)cbEstado.getSelectedItem();
        int tipoBusca = 0;
        if(codigoStr.trim().equals("")) {
            if(cpf.replaceAll("[-./ ]","").equals("")) {
                tipoBusca = 2;
            }
            else
                tipoBusca = 1;
        }
        
        Militar militar;
        if(tipoBusca == 0) {
            int codigo = Utils.stringToInt(codigoStr);
            militar = MilitarController.buscarMilitar(codigo);
        }
        else if(tipoBusca == 1)
            militar = MilitarController.buscarMilitarCPF(cpf);
        else
            militar = MilitarController.buscarMilitarRG(rg,estado);

        if(militar != null) {
            setCamposFromMilitar(militar);

            btEditarMilitar.setEnabled(true);
            btExcluirMilitar.setEnabled(true);
            
            militarAtual = militar;
        }
        else {
            limparCampos();
        }
    }//GEN-LAST:event_btBuscarMilitarActionPerformed
                

    
    private void btExcluirMilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirMilitarActionPerformed
      if(militarAtual != null) {
          MilitarController.excluirMilitar(militarAtual);
      }
    }//GEN-LAST:event_btExcluirMilitarActionPerformed

    private void rbSoldadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSoldadoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkDescascarBatatas.setEnabled(true);
            chkLimparBanheiro.setEnabled(true);
            chkLimparCozinha.setEnabled(true);
            chkLimparEstabulos.setEnabled(true);
        }
    }//GEN-LAST:event_rbSoldadoItemStateChanged

    private void rbCaboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCaboItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkDescascarBatatas.setEnabled(true);
            chkLimparCozinha.setEnabled(true);
            chkLimparEstabulos.setEnabled(true);
            chkRecarregar.setEnabled(true);
        }
    }//GEN-LAST:event_rbCaboItemStateChanged

    private void rbTerceiroSargentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbTerceiroSargentoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkDescascarBatatas.setEnabled(true);
            chkLimparCozinha.setEnabled(true);
            chkRecarregar.setEnabled(true);
            chkAlimentarCavalos.setEnabled(true);
        }
    }//GEN-LAST:event_rbTerceiroSargentoItemStateChanged

    private void rbSegundoSargentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSegundoSargentoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkLimparCozinha.setEnabled(true);
            chkRecarregar.setEnabled(true);
            chkAlimentarCavalos.setEnabled(true);
            chkCozinharJanta.setEnabled(true);
        }
    }//GEN-LAST:event_rbSegundoSargentoItemStateChanged

    private void rbPrimeiroSargentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPrimeiroSargentoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkRecarregar.setEnabled(true);
            chkAlimentarCavalos.setEnabled(true);
            chkCozinharJanta.setEnabled(true);
            chkTrocarEncanamento.setEnabled(true);
        }
    }//GEN-LAST:event_rbPrimeiroSargentoItemStateChanged

    private void rbSubtenenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSubtenenteItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkRecarregar.setEnabled(true);
            chkAlimentarCavalos.setEnabled(true);
            chkCozinharAlmoco.setEnabled(true);
            chkTrocarEncanamento.setEnabled(true);
        }
    }//GEN-LAST:event_rbSubtenenteItemStateChanged

    private void rbAspiranteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbAspiranteItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkRecarregar.setEnabled(true);
            chkCozinharAlmoco.setEnabled(true);
            chkTrocarEncanamento.setEnabled(true);
            chkLevantarBandeira.setEnabled(true);
        }
    }//GEN-LAST:event_rbAspiranteItemStateChanged

    private void rbSegundoTenenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSegundoTenenteItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkCozinharJanta.setEnabled(true);
            chkTrocarEncanamento.setEnabled(true);
            chkLevantarBandeira.setEnabled(true);
        }
    }//GEN-LAST:event_rbSegundoTenenteItemStateChanged

    private void rbPrimeiroTenenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPrimeiroTenenteItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkCozinharJanta.setEnabled(true);
            chkLevantarBandeira.setEnabled(true);
        }
    }//GEN-LAST:event_rbPrimeiroTenenteItemStateChanged

    private void rbCapitaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCapitaoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            limparTarefas();
            chkLevantarBandeira.setEnabled(true);
        }
    }//GEN-LAST:event_rbCapitaoItemStateChanged

    private void ftfNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfNascimentoFocusLost
        updateCampoIdade();
    }//GEN-LAST:event_ftfNascimentoFocusLost

    private void tfIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdadeActionPerformed

    private void rbSoldadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSoldadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSoldadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbCodigo;
    private javax.swing.JLabel LbCpf;
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbIdade;
    private javax.swing.JLabel LbNascimento;
    private javax.swing.JLabel LbNome;
    private javax.swing.JLabel LbRg;
    private javax.swing.JLabel LbSexo;
    private javax.swing.JLabel LbSexo1;
    private javax.swing.JButton btBuscarMilitar;
    private javax.swing.JButton btCadastrarMilitar;
    private javax.swing.JButton btEditarMilitar;
    private javax.swing.JButton btExcluirMilitar;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JCheckBox chkAlimentarCavalos;
    private javax.swing.JCheckBox chkCozinharAlmoco;
    private javax.swing.JCheckBox chkCozinharJanta;
    private javax.swing.JCheckBox chkDescascarBatatas;
    private javax.swing.JCheckBox chkLevantarBandeira;
    private javax.swing.JCheckBox chkLimparBanheiro;
    private javax.swing.JCheckBox chkLimparCozinha;
    private javax.swing.JCheckBox chkLimparEstabulos;
    private javax.swing.JCheckBox chkRecarregar;
    private javax.swing.JCheckBox chkTrocarEncanamento;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfNascimento;
    private javax.swing.JFormattedTextField ftfRg;
    private javax.swing.JLabel lbAspirante;
    private javax.swing.JLabel lbCabo;
    private javax.swing.JLabel lbCapitao;
    private javax.swing.JLabel lbPrimeiroSargento;
    private javax.swing.JLabel lbPrimeiroTenente;
    private javax.swing.JLabel lbSegundoSargento;
    private javax.swing.JLabel lbSegundoTenente;
    private javax.swing.JLabel lbSoldado;
    private javax.swing.JLabel lbSubtenente;
    private javax.swing.JLabel lbTerceiroSargento;
    private javax.swing.JPanel panelDadosMilitar;
    private javax.swing.JPanel panelOpcoes;
    private javax.swing.JPanel panelTarefas;
    private javax.swing.JRadioButton rbAspirante;
    private javax.swing.JRadioButton rbCabo;
    private javax.swing.JRadioButton rbCapitao;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JRadioButton rbPrimeiroSargento;
    private javax.swing.JRadioButton rbPrimeiroTenente;
    private javax.swing.JRadioButton rbSegundoSargento;
    private javax.swing.JRadioButton rbSegundoTenente;
    private javax.swing.JRadioButton rbSoldado;
    private javax.swing.JRadioButton rbSubtenente;
    private javax.swing.JRadioButton rbTerceiroSargento;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
