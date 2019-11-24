import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame
{
    JFrame jfrmMain;
    public JButton logoutAdminButton;
    private JPanel mainPanel;
    private JButton adminButton;
    private JButton userButton;
    private JButton creditsButton;
    private JButton logoutUserButton;
    private JButton collegeButton;
    private JButton logoutCollegeButton;

    MainFrame()
    {
        logoutAdminButton.setEnabled(false);
        logoutUserButton.setEnabled(false);
        logoutCollegeButton.setEnabled(false);
        jfrmMain = new JFrame();
        jfrmMain.add(mainPanel);
        jfrmMain.setTitle("Find Colleges");
        jfrmMain.setSize(600, 500);
        jfrmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrmMain.setLocationRelativeTo(null);

        adminButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (ExecApplication.userLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off User Account first, before signing into Admin Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                else if (ExecApplication.collegeLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off College Account first, before signing into Admin Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);

                else if (ExecApplication.adminLoggedIn)
                {
                    AdminDialog admDig = new AdminDialog();
                    admDig.setVisible(true);
                } else
                {
                    AdminLogin admLgn = new AdminLogin();
                    admLgn.setVisible(true);

                    if (ExecApplication.adminLoggedIn) logoutAdminButton.setEnabled(true);
                }
            }
        });
        userButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (ExecApplication.adminLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off Admin Account first, before signing into Student Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                else if (ExecApplication.collegeLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off College Account first, before signing into Student Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                else if (ExecApplication.userLoggedIn)
                {
                    UserDialog userDialog = new UserDialog();
                    userDialog.setVisible(true);
                } else
                {
                    UserLogin userLogin = new UserLogin();
                    userLogin.setVisible(true);

                }

                if (ExecApplication.userLoggedIn)
                {
                    logoutUserButton.setEnabled(true);
                } else
                {
                    logoutUserButton.setEnabled(false);
                }
            }
        });
        collegeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (ExecApplication.adminLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off Admin Account first, before signing into College Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                else if (ExecApplication.userLoggedIn) JOptionPane.showMessageDialog(null, "Please Log off Student Account first, before signing into College Account.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                else if (ExecApplication.collegeLoggedIn)
                {
                    CollegeDialog collegeDialog = new CollegeDialog();
                    collegeDialog.setEmail(ExecApplication.collegeEmail);
                    collegeDialog.setVisible(true);

                } else
                {
                    CollegeLoginDialog collegeLoginDialog = new CollegeLoginDialog();
                    collegeLoginDialog.setVisible(true);

                }
                if (!ExecApplication.collegeLoggedIn) logoutCollegeButton.setEnabled(false);
                if (ExecApplication.collegeLoggedIn) logoutCollegeButton.setEnabled(true);
            }
        });
        creditsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //                CreditDialog crd = new CreditDialog();
                //                crd.setVisible(true);
                CreditsDialog creditsDialog = new CreditsDialog();
                creditsDialog.setVisible(true);
            }
        });
        logoutAdminButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ExecApplication.adminLoggedIn = false;
                logoutAdminButton.setEnabled(false);
            }
        });
        logoutUserButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ExecApplication.userLoggedIn = false;
                logoutUserButton.setEnabled(false);
            }
        });
        logoutCollegeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ExecApplication.collegeLoggedIn = false;
                logoutCollegeButton.setEnabled(false);
            }
        });

    }

    {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$(null, -1, 36, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Find College");
        mainPanel.add(label1, new GridConstraints(0, 0, 2, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adminButton = new JButton();
        adminButton.setText("Admin");
        mainPanel.add(adminButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userButton = new JButton();
        userButton.setText("Student");
        mainPanel.add(userButton, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        mainPanel.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        creditsButton = new JButton();
        creditsButton.setText("Credits");
        mainPanel.add(creditsButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutAdminButton = new JButton();
        logoutAdminButton.setText("Logout Admin");
        mainPanel.add(logoutAdminButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutUserButton = new JButton();
        logoutUserButton.setText("Logout Student");
        mainPanel.add(logoutUserButton, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        collegeButton = new JButton();
        collegeButton.setText("College");
        mainPanel.add(collegeButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutCollegeButton = new JButton();
        logoutCollegeButton.setText("Logout College");
        mainPanel.add(logoutCollegeButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        } else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            } else
            {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }

}
