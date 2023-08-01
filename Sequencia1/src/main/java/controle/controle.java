package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableColumnModel;

import conexao.Conexao;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class controle extends JFrame
{
    Conexao con_cliente;
    
    JLabel rCodigo, rNome, rEmail, rTel, rData;
    JTextField tcodigo, tnome, temail;
    JFormattedTextField tel, data;
    MaskFormatter mTel, mData;
    
    JTable tblClientes; //datagrid
    JScrollPane scp_tabela; //container para o datagrid
    
    public controle()
    {
        con_cliente = new Conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta

        setTitle("Conexão Java com Mysql");
        setResizable(false);
        Container tela = getContentPane();
        
        rCodigo = new JLabel("Código");
        rNome= new JLabel("Nome");
        rEmail = new JLabel("Email");
        rTel = new JLabel("Telefone");
        rData = new JLabel("Data");
        tcodigo= new JTextField(20);
        tnome = new JTextField(50);
        temail = new JTextField(50);
        
        //config mascara
        
        try
        {

            mTel= new MaskFormatter("(##)####--####");
            mData = new MaskFormatter("##/##/####");
            mTel.setPlaceholderCharacter('_');
            mData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}
        tel = new JFormattedTextField(mTel);
        data = new JFormattedTextField(mData);
        
        //config tela
        rCodigo.setBounds(80,120,100,20);
        tcodigo.setBounds(150,120,100,20);
        rNome.setBounds(100,150,100,20);
        tnome.setBounds(180,150,100,20);
        rEmail.setBounds(140,185,100,20); 
        temail.setBounds(200,185,100,20);
        rData.setBounds(160,240,100,20);
        data.setBounds(240,240,100,20);
        rTel.setBounds(200,280,100,20);
        tel.setBounds(260,280,100,20);
        tela.add(rCodigo);
        tela.add(rNome);
        tela.add(rEmail);
        tela.add(rTel);
        tela.add(rData);
        tela.add(tcodigo);
        tela.add(tnome);
        tela.add(temail);
        tela.add(tel);
        tela.add(data);
        
        //tabela
        tblClientes = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();
        
        tblClientes.setBounds(50,200,550,200);
        scp_tabela.setBounds(50,200,550,200);
        
        tela.add(tblClientes);
        tela.add(scp_tabela);
        
        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
       
        tblClientes.setFont(new java.awt.Font("Arial",1,12));
        
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][]{
            {null, null, null, null, null},
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null}
        },
        new String []{ "Código", "Nome", "Data Nascimento", "Telefone", "Email"})
        {
            boolean[] canEdit = new boolean[]{false,false,false,false,false};
            
            public boolean isCellEditable(int rowIndex, int columnIdex){
            return canEdit [columnIdex];}
        });
        scp_tabela.setViewportView(tblClientes);
        
        tblClientes.setAutoCreateRowSorter(true);
        
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
    
    }


}
