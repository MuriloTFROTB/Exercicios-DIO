import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceSwing {
    public static void main(String[] args) {
        // Criar a janela (JFrame)
        JFrame frame = new JFrame("Minha Interface Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Criar os componentes
        JLabel label = new JLabel("Digite seu nome:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Enviar");
        JLabel resposta = new JLabel();

        // Ação do botão
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText();
                resposta.setText("Olá, " + nome + "!");
            }
        });

        // Organizar os componentes em um painel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // 4 linhas, 1 coluna
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(resposta);

        // Adicionar painel à janela e exibir
        frame.add(panel);
        frame.setVisible(true);
    }
}
