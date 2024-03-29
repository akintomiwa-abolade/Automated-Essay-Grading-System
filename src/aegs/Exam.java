/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aegs;

//import edu.smu.tspell.wordnet.Synset;
//import edu.smu.tspell.wordnet.WordNetDatabase;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Exam extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Exam
     */
    Connection con;
    Statement st;
    ResultSet rs, qs;
    PreparedStatement ps;
    int index = 1, que, tim, score;
    Thread t;
    ArrayList<String[]> record, solution;
    String course;

    public Exam(String code, int noq, int time) {
        Student.exam_on = true;
        initComponents();
        initDb();
        loadQuestion(code);
        Collections.shuffle(record);
        solution = new ArrayList<>();
        que = noq;
        tim = time;
        course = code;

        this.time.setText(time - 1 + " : 59");
        course_code.setText(code.toUpperCase() + " Examination");
        current_question.setText("Question 1 of " + noq);
        mark.setText(record.get(0)[2] + " Marks");
        current_answer.setText("Solution to Question 1");
        question.setText(record.get(0)[1]);
        t = new Thread(this);
        t.start();
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

    private void loadQuestion(String code) {
        try {
            rs = st.executeQuery("SELECT question_id, question, question_mark FROM question WHERE course_id = '" + code + "'");
            record = new ArrayList<>();
            String[] row;

            while (rs.next()) {
                row = new String[3];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3) + "";
                record.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
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

        time = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        answer = new javax.swing.JTextArea();
        current_answer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        current_question = new javax.swing.JLabel();
        previous = new javax.swing.JButton();
        mark = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        course_code = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Examination Page", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        setMaximumSize(new java.awt.Dimension(778, 503));
        setMinimumSize(new java.awt.Dimension(778, 503));

        time.setBackground(new java.awt.Color(0, 0, 0));
        time.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 0, 0));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("19:55");
        time.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        time.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        time.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(700, 402));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 402));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 402));
        jPanel2.setLayout(null);

        answer.setColumns(20);
        answer.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        answer.setForeground(new java.awt.Color(255, 0, 0));
        answer.setLineWrap(true);
        answer.setRows(5);
        answer.setWrapStyleWord(true);
        answer.setBorder(null);
        answer.setOpaque(true);
        jScrollPane2.setViewportView(answer);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(30, 220, 650, 110);

        current_answer.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        current_answer.setText("Solution to Question 5");
        jPanel2.add(current_answer);
        current_answer.setBounds(50, 190, 200, 30);

        question.setEditable(false);
        question.setColumns(20);
        question.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        question.setLineWrap(true);
        question.setRows(5);
        question.setWrapStyleWord(true);
        question.setBorder(null);
        question.setOpaque(true);
        jScrollPane1.setViewportView(question);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 660, 130);

        current_question.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        current_question.setText("Question 5 of 20");
        jPanel2.add(current_question);
        current_question.setBounds(50, 30, 150, 30);

        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        jPanel2.add(previous);
        previous.setBounds(0, 380, 160, 28);

        mark.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        mark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mark.setText("5 Marks");
        jPanel2.add(mark);
        mark.setBounds(200, 40, 100, 19);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aegs/images/board.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 375);

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        jPanel2.add(next);
        next.setBounds(540, 380, 150, 28);

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel2.add(submit);
        submit.setBounds(190, 380, 330, 28);

        course_code.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        course_code.setForeground(new java.awt.Color(255, 255, 255));
        course_code.setText("CSE505 Examination");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(course_code, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(course_code, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        if (index > 1) {
            String[] row = {record.get(index - 1)[0], answer.getText()};

            if (solution.size() > index - 1) {
                solution.remove(index - 1);
            }
            solution.add(index - 1, row);
            index--;

            current_question.setText("Question " + index + " of " + que);
            mark.setText(record.get(index - 1)[2] + " Marks");
            current_answer.setText("Solution to Question " + index);
            answer.setText(solution.get(index - 1)[1]);
            question.setText(record.get(index - 1)[1]);
        }
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if (index < que) {
            String[] row = {record.get(index - 1)[0], answer.getText()};

            if (solution.size() > index - 1) {
                solution.remove(index - 1);
            }
            solution.add(index - 1, row);
            index++;

            current_question.setText("Question " + index + " of " + que);
            mark.setText(record.get(index - 1)[2] + " Marks");
            current_answer.setText("Solution to Question " + index);
            question.setText(record.get(index - 1)[1]);
            if (solution.size() > index - 1) {
                answer.setText(solution.get(index - 1)[1]);
            } else {
                answer.setText("");
            }
        }
    }//GEN-LAST:event_nextActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(current_answer, "Are you sure u wanna submit");
        if (a == JOptionPane.YES_OPTION) {
            t.stop();
           // grade();
        }
    }//GEN-LAST:event_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answer;
    private javax.swing.JLabel course_code;
    private javax.swing.JLabel current_answer;
    private javax.swing.JLabel current_question;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mark;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JTextArea question;
    private javax.swing.JButton submit;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        for (int i = tim - 1; i >= 0; i--) {
            for (int j = 59; j >= 0; j--) {
                try {
                    time.setText(i + " : " + j);
                    t.sleep(999);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //submit
       // grade();
    }

   /* private void grade() {
        String[] row = {record.get(index - 1)[0], answer.getText()};
        if (solution.size() > index - 1) {
            solution.remove(index - 1);
        }
        solution.add(index - 1, row);
        submit.setEnabled(false);

        ArrayList<String[]> result = new ArrayList<>();
        Student.exam_on = false;
        double total, stotal;
        total = stotal = 0;
        ArrayList<String> responds;
        try {
            for (int i = 0; i < que; i++) {
                responds = new ArrayList<>();

                responds.add(record.get(i)[1]);

                total += Integer.parseInt(record.get(i)[2]);

                rs = st.executeQuery("SELECT count(*) FROM keyword WHERE question_id = '" + record.get(i)[0] + "'");
                rs.next();
                int nok = rs.getInt(1);

                rs = st.executeQuery("SELECT keyword FROM keyword WHERE question_id = '" + record.get(i)[0] + "'");
                String map;
                while (rs.next()) {
                    map = rs.getString(1);
                    responds.add(map);
                    String[] mapping = synonyms(map);
                    System.out.println(Arrays.toString(mapping));
                    for (String a : mapping) {
                        if (solution.get(i)[1].toLowerCase().contains(a)) {
                            stotal += (1.0 / nok) * Integer.parseInt(record.get(i)[2]);
                            break;
                        }
                    }
                }
                responds.add(solution.get(i)[1]);
                result.add(responds.toArray(new String[responds.size()]));
            }

            score = (int) Math.round((stotal / total) * 100);

            GregorianCalendar cal = new GregorianCalendar();
            String date = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1 )+ "/" + cal.get(Calendar.YEAR) + "  " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.AM_PM);

            ps = con.prepareStatement("Insert Into score Values(?,?,?,?)");
            ps.setString(1, Student.matric.getText());
            ps.setString(2, course);
            ps.setInt(3, score);
            ps.setString(4, date);
            ps.executeUpdate();

            responds = new ArrayList<>();
            responds.add(score + "");
            responds.add(date);
            result.add(responds.toArray(new String[responds.size()]));

            Student.container.removeAll();
            Student.container.add(new ExamResult(result));
            Student.container.repaint();
            Student.container.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

    /*private String[] synonyms(String key) {
        String path = "C:\\Program Files (x86)\\WordNet\\2.1\\dict";
        System.setProperty("wordnet.database.dir", path);
        WordNetDatabase database = WordNetDatabase.getFileInstance();

        Synset[] synsets = database.getSynsets(key);

        Set<String> word = new HashSet<>();
        word.add(key);
        for (Synset a : synsets) {
            word.addAll(Arrays.asList(a.getWordForms()));
        }
        String[] words = word.toArray(new String[word.size()]);
        return words;
    }*/
}
