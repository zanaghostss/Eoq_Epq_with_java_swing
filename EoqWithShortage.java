import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EoqWithShortage extends JFrame implements ActionListener {

    private JButton jButton_back;
    private JLabel info;
    private JTextField D, A, H, S;

    private JLabel qlabel, nlabel, tc_label, to_label, total;
    private JButton computeButton;

    public EoqWithShortage() {
        setTitle("EOQ با کمبود موجودی");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels
        JPanel inputPanel = new JPanel(new GridBagLayout());
        JPanel outputPanel = new JPanel(new GridLayout(5, 1));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // Create components
        info = new JLabel("MAKE BY ZANA ABDI", SwingConstants.CENTER);
        D = new JTextField(10);
        A = new JTextField(10);
        H = new JTextField(10);
        S = new JTextField(10);
        qlabel = new JLabel("q: ");
        nlabel = new JLabel("N: ");
        tc_label = new JLabel("tc: ");
        to_label = new JLabel("to: ");
        total = new JLabel("total: ");
        computeButton = new JButton("محاسبه کن");
        jButton_back = new JButton("Back");

        // Configure components
        computeButton.addActionListener(this);
        jButton_back.addActionListener(this);

        // Add components to input panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("تقاضا: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(D, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("هزینه سفارش دهی: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(A, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("هزینه نگهداری: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(H, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("کمبود موجودی: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(S, gbc);

        // Add components to output panel
        outputPanel.add(qlabel);
        outputPanel.add(nlabel);
        outputPanel.add(tc_label);
        outputPanel.add(to_label);
        outputPanel.add(total);

        // Add components to button panel
        buttonPanel.add(computeButton);
        buttonPanel.add(jButton_back);

        // Add panels to frame
        add(info, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeButton) {
            // Get values from text fields
            double demand = Double.parseDouble(D.getText());
            double setupCost = Double.parseDouble(A.getText());
            double holdingCost = Double.parseDouble(H.getText());
            double shortageCost = Double.parseDouble(S.getText());

            // Calculate parameters
            double qw = Math.sqrt((2 * demand * setupCost) / holdingCost);
            int n_ = (int) (demand / qw);
            double negahdari = (holdingCost * qw) / 2 + (demand * setupCost) + (shortageCost * demand / qw);
            double segaresh = (demand * setupCost) / qw;
            double sum = negahdari + segaresh;

            // Update labels with results
            qlabel.setText("q: " + qw);
            nlabel.setText("N: " + n_);
            tc_label.setText("tc: " + negahdari);
            to_label.setText("to: " + segaresh);
            total.setText("total: " + sum);
        }

        if (e.getSource() == jButton_back) {
            dispose();
            new Buttons().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new EoqWithShortage().setVisible(true);
    }
}
