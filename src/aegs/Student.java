/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aegs;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Student extends javax.swing.JPanel {

    /**
     * Creates new form Student
     *
     * @param matric
     */
    Connection con;
    Statement st;
    ResultSet rs;
    static String mat;
    static Boolean exam_on = false;

    public Student(String matric) {
        mat = matric;
        initComponents();
        initDb();
        addStudent();

        Student.matric.setText(matric);

        container.removeAll();
        container.add(new Course());
        container.repaint();
        container.revalidate();
    }

    private void addStudent() {
        try {
            rs = st.executeQuery("Select* From student Where matric ='" + mat + "'");

            while (rs.next()) {
                name.setText(rs.getString(2));
                dept.setText(rs.getString(4));
                sex.setText(rs.getString(5));
                phone.setText(rs.getString(6));
                email.setText(rs.getString(7));
                country.setText(rs.getString(8));
                state.setText(rs.getString(9));
                Image image = Toolkit.getDefaultToolkit().createImage(rs.getString(10));
                image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                this.image.setIcon(new ImageIcon(image));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initDb() {
        try {
            new Database();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AEGS", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Connecting to the Database\nConnect the DBMS and run the application again!");
            System.exit(0);
            ex.printStackTrace();
        }
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
        matric = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        dept = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        country = new javax.swing.JLabel();
        state = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1100, 530));
        setMinimumSize(new java.awt.Dimension(1100, 530));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Profile", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(330, 530));
        jPanel1.setMinimumSize(new java.awt.Dimension(330, 530));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 530));

        matric.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        matric.setForeground(new java.awt.Color(255, 0, 0));
        matric.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        matric.setText("Matric");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aegs/images/profile.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Sex:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Dept:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Phone:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Country:");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("State:");

        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Name:");
        name.setMaximumSize(new java.awt.Dimension(210, 24));
        name.setMinimumSize(new java.awt.Dimension(210, 24));
        name.setPreferredSize(new java.awt.Dimension(210, 24));

        sex.setForeground(new java.awt.Color(255, 255, 255));
        sex.setText("Sex:");
        sex.setMaximumSize(new java.awt.Dimension(210, 24));
        sex.setMinimumSize(new java.awt.Dimension(210, 24));
        sex.setPreferredSize(new java.awt.Dimension(210, 24));

        dept.setForeground(new java.awt.Color(255, 255, 255));
        dept.setText("Dept:");
        dept.setMaximumSize(new java.awt.Dimension(210, 24));
        dept.setMinimumSize(new java.awt.Dimension(210, 24));
        dept.setPreferredSize(new java.awt.Dimension(210, 24));

        phone.setForeground(new java.awt.Color(255, 255, 255));
        phone.setText("Phone:");
        phone.setMaximumSize(new java.awt.Dimension(210, 24));
        phone.setMinimumSize(new java.awt.Dimension(210, 24));
        phone.setPreferredSize(new java.awt.Dimension(210, 24));

        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email:");
        email.setMaximumSize(new java.awt.Dimension(210, 24));
        email.setMinimumSize(new java.awt.Dimension(210, 24));
        email.setPreferredSize(new java.awt.Dimension(210, 24));

        country.setForeground(new java.awt.Color(255, 255, 255));
        country.setText("Country:");
        country.setMaximumSize(new java.awt.Dimension(210, 24));
        country.setMinimumSize(new java.awt.Dimension(210, 24));
        country.setPreferredSize(new java.awt.Dimension(210, 24));

        state.setForeground(new java.awt.Color(255, 255, 255));
        state.setText("State:");
        state.setMaximumSize(new java.awt.Dimension(210, 24));
        state.setMinimumSize(new java.awt.Dimension(210, 24));
        state.setPreferredSize(new java.awt.Dimension(210, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(matric, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(matric, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        logout.setBackground(new java.awt.Color(255, 0, 0));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setBorder(null);
        logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout.setOpaque(true);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Student.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Student.this.mouseExited(evt);
            }
        });

        result.setBackground(new java.awt.Color(255, 0, 0));
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("Result");
        result.setBorder(null);
        result.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        result.setOpaque(true);
        result.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Student.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Student.this.mouseExited(evt);
            }
        });

        course.setBackground(new java.awt.Color(255, 0, 0));
        course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        course.setText("Course");
        course.setBorder(null);
        course.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        course.setOpaque(true);
        course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student.this.mouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Student.this.mouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Student.this.mouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(course, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setMaximumSize(new java.awt.Dimension(770, 490));
        container.setMinimumSize(new java.awt.Dimension(770, 490));
        container.setPreferredSize(new java.awt.Dimension(770, 490));
        container.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
        // TODO add your handling code here:
        if (exam_on) {
            JOptionPane.showMessageDialog(container, "Complete this attempt before leaving page!");
        } else {
            if (evt.getSource() == course) {
                container.removeAll();
                container.add(new Course());
                container.repaint();
                container.revalidate();
            } else if (evt.getSource() == result) {
                container.removeAll();
                container.add(new Result());
                container.repaint();
                container.revalidate();
            } else if (evt.getSource() == logout) {
                Frame.container.removeAll();
                Frame.container.add(new Login());
                Frame.container.repaint();
                Frame.container.revalidate();
            }
        }
    }//GEN-LAST:event_mouseClicked

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        // TODO add your handling code here:
        if (evt.getSource() == course) {
            course.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        } else if (evt.getSource() == result) {
            result.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        } else if (evt.getSource() == logout) {
            logout.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        }
    }//GEN-LAST:event_mouseEntered

    private void mouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExited
        // TODO add your handling code here:
        if (evt.getSource() == course) {
            course.setBorder(null);
        } else if (evt.getSource() == result) {
            result.setBorder(null);
        } else if (evt.getSource() == logout) {
            logout.setBorder(null);
        }
    }//GEN-LAST:event_mouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel container;
    private javax.swing.JLabel country;
    private javax.swing.JLabel course;
    private javax.swing.JLabel dept;
    private javax.swing.JLabel email;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logout;
    protected static javax.swing.JLabel matric;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel result;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel state;
    // End of variables declaration//GEN-END:variables
}
