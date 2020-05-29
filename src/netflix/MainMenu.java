/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Poyraz
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    DefaultTableModel model;
    JLabel picture;
    Timer timer;
    int x = 0;
    Date today=java.util.Calendar.getInstance().getTime();
    String[] listOfPictures = {
        "1.jpg",
        "2.jpg",
        "3.jpg",
        "4.jpg",
        "5.jpg",
        "6.jpg",
        "7.jpg",
        "8.jpg",
        "9.jpg",
        "10.jpg",
        "11.jpg",
        "12.jpg",
        "13.jpg",};

    String[] listOfGenres = {
        "Aksiyon ve Macera",
        "Bilim Kurgu ve Fantastik Yapımlar",
        "Romantik",
        "Drama",
        "Çocuk ve Aile",
        "Belgesel",
        "Komedi",
        "Aksiyon",
        "Korku",
        "Bilim ve Doğa",
        "Bilim Kurgu",
        "Gerilim",
        "Anime",
        "Reality Program",};
    String[] listOfSelectedGenres = new String[3];
    String[] listOfMoviesHighRated;
    String[] listOfGenreSelectedFirst = new String[2];
    String[] listOfGenreSelectedSecond = new String[2];
    String[] listOfGenreSelectedThird = new String[2];
    User currentUser;

    public MainMenu() {
        initComponents();
        slideShow();
        populateTable();
    }

    private void slideShow() {
        picture = new JLabel();
        picture.setBounds(0, 0, 1024, 768);
        SetImageSize(listOfPictures.length - 1);

        timer = new Timer(5000, (ActionEvent e) -> {
            SetImageSize(x);
            x += 1;
            if (x >= listOfPictures.length) {
                x = 0;
            }
        });
        add(picture);
        timer.start();
        setLayout(null);
        setSize(1024, 768);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        jPanelSignUp.setVisible(false);
    }

    public void SetImageSize(int i) {
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader()
                .getResource(listOfPictures[i]));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(picture.getWidth(),
                picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        picture.setIcon(newImageIcon);
    }

    public ArrayList<Programme> getProgrammes() {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Programme> programmes = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from programme");
            programmes = new ArrayList<Programme>();
            while (resultSet.next()) {
                programmes.add(new Programme(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getString("genre"),
                        resultSet.getInt("number_of_episodes"),
                        resultSet.getInt("length_of_programme")));
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            dbHelper.showErrorMessage(ex);
        }
        return programmes;
    }

    public void populateTable() {
        model = (DefaultTableModel) jTableProgrammes.getModel();
        ArrayList<Programme> programmes = getProgrammes();
        for (Programme programme : programmes) {
            Object[] row = {programme.getName(), programme.getType(),
                programme.getGenre(), programme.getNumberOfEpisodes(), programme.getLengthOfProgramme()};
            model.addRow(row);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelSignIn = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMailSignIn = new javax.swing.JTextField();
        jButtonSignIn = new javax.swing.JButton();
        jPasswordFieldSignIn = new javax.swing.JPasswordField();
        jButtonLinkToSignUp = new javax.swing.JButton();
        jPanelSignUp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMailSignUp = new javax.swing.JTextField();
        jPasswordFieldSignUpConfirmation = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldSignUp = new javax.swing.JPasswordField();
        jButtonLinkToSignIn = new javax.swing.JButton();
        jButtonSignUp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDateChooserDateOfBirth = new com.toedter.calendar.JDateChooser();
        jPanelMoviesGenres = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMovieGenres = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jButtonLinkToMoviesHighRated = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanelMoviesHighRated = new javax.swing.JPanel();
        jLabelThirdGenre = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSelectedGenreThird = new javax.swing.JList<>();
        jLabelFirstGenre = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSelectedGenreFirst = new javax.swing.JList<>();
        jLabelSecondGenre = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListSelectedGenreSecond = new javax.swing.JList<>();
        jButtonLinkToNetflixUI = new javax.swing.JButton();
        jPanelNetflixUI = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProgrammes = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButtonWatchMovies = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldRating = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NETFLIX");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanelSignIn.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f));
        jPanelSignIn.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("         NETFLIX");
        jPanelSignIn.add(jLabel4);
        jLabel4.setBounds(150, 50, 350, 35);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Parola :");
        jPanelSignIn.add(jLabel5);
        jLabel5.setBounds(80, 190, 100, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("E-posta : ");
        jPanelSignIn.add(jLabel6);
        jLabel6.setBounds(76, 140, 100, 23);

        jTextFieldMailSignIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldMailSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMailSignInActionPerformed(evt);
            }
        });
        jPanelSignIn.add(jTextFieldMailSignIn);
        jTextFieldMailSignIn.setBounds(210, 130, 280, 40);

        jButtonSignIn.setBackground(new java.awt.Color(102, 0, 0));
        jButtonSignIn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignIn.setText("Giriş Yap !");
        jButtonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignInActionPerformed(evt);
            }
        });
        jPanelSignIn.add(jButtonSignIn);
        jButtonSignIn.setBounds(260, 260, 169, 92);

        jPasswordFieldSignIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordFieldSignIn.setText("");
        jPasswordFieldSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSignInActionPerformed(evt);
            }
        });
        jPanelSignIn.add(jPasswordFieldSignIn);
        jPasswordFieldSignIn.setBounds(210, 190, 280, 30);

        jButtonLinkToSignUp.setBackground(new java.awt.Color(51, 51, 51));
        jButtonLinkToSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonLinkToSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLinkToSignUp.setText("Daha kayıt olmadın mı? ");
        jButtonLinkToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLinkToSignUpActionPerformed(evt);
            }
        });
        jPanelSignIn.add(jButtonLinkToSignUp);
        jButtonLinkToSignUp.setBounds(220, 380, 246, 31);

        jLayeredPane1.add(jPanelSignIn, "card2");

        jPanelSignUp.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f));
        jPanelSignUp.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("       NETFLIX'e hoş geldin!");
        jPanelSignUp.add(jLabel1);
        jLabel1.setBounds(110, 40, 430, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Parola Doğrula : ");
        jPanelSignUp.add(jLabel2);
        jLabel2.setBounds(120, 400, 160, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-posta : ");
        jPanelSignUp.add(jLabel3);
        jLabel3.setBounds(120, 300, 100, 25);

        jTextFieldMailSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldMailSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMailSignUpActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jTextFieldMailSignUp);
        jTextFieldMailSignUp.setBounds(290, 290, 270, 40);

        jPasswordFieldSignUpConfirmation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordFieldSignUpConfirmation.setText("");
        jPasswordFieldSignUpConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSignUpConfirmationActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jPasswordFieldSignUpConfirmation);
        jPasswordFieldSignUpConfirmation.setBounds(290, 400, 270, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Parola : ");
        jPanelSignUp.add(jLabel7);
        jLabel7.setBounds(120, 350, 100, 30);

        jPasswordFieldSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordFieldSignUp.setText("");
        jPasswordFieldSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSignUpActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jPasswordFieldSignUp);
        jPasswordFieldSignUp.setBounds(290, 350, 270, 30);

        jButtonLinkToSignIn.setBackground(new java.awt.Color(51, 51, 51));
        jButtonLinkToSignIn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonLinkToSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLinkToSignIn.setText("<-GERİ");
        jButtonLinkToSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLinkToSignInActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jButtonLinkToSignIn);
        jButtonLinkToSignIn.setBounds(120, 460, 120, 40);

        jButtonSignUp.setBackground(new java.awt.Color(102, 0, 0));
        jButtonSignUp.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSignUp.setText("Şimdi Kayıt Ol !");
        jButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUpActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jButtonSignUp);
        jButtonSignUp.setBounds(280, 460, 260, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kullanıcı Adı:");
        jPanelSignUp.add(jLabel8);
        jLabel8.setBounds(120, 180, 150, 30);

        jTextFieldUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserNameActionPerformed(evt);
            }
        });
        jPanelSignUp.add(jTextFieldUserName);
        jTextFieldUserName.setBounds(290, 170, 270, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Doğum Tarihi:");
        jPanelSignUp.add(jLabel9);
        jLabel9.setBounds(120, 240, 150, 30);

        jDateChooserDateOfBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanelSignUp.add(jDateChooserDateOfBirth);
        jDateChooserDateOfBirth.setBounds(290, 230, 270, 40);

        jLayeredPane1.add(jPanelSignUp, "card3");

        jPanelMoviesGenres.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f));
        jPanelMoviesGenres.setLayout(null);

        jListMovieGenres.setBackground(new java.awt.Color(51, 51, 51));
        jListMovieGenres.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jListMovieGenres.setForeground(new java.awt.Color(255, 255, 255));
        jListMovieGenres.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return listOfGenres.length; }
            public String getElementAt(int i) { return listOfGenres[i]; }
        });
        jScrollPane1.setViewportView(jListMovieGenres);

        jPanelMoviesGenres.add(jScrollPane1);
        jScrollPane1.setBounds(90, 100, 500, 320);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Üç Farklı Program Türü Seçiniz:");
        jPanelMoviesGenres.add(jLabel10);
        jLabel10.setBounds(10, 20, 650, 49);

        jButtonLinkToMoviesHighRated.setBackground(new java.awt.Color(102, 0, 0));
        jButtonLinkToMoviesHighRated.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonLinkToMoviesHighRated.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLinkToMoviesHighRated.setText("DEVAM->");
        jButtonLinkToMoviesHighRated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLinkToMoviesHighRatedActionPerformed(evt);
            }
        });
        jPanelMoviesGenres.add(jButtonLinkToMoviesHighRated);
        jButtonLinkToMoviesHighRated.setBounds(190, 470, 280, 50);

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("*Çoklu seçimlerinizi Ctrl + Mouse Left Click ile yapabilirsiniz.");
        jPanelMoviesGenres.add(jLabel12);
        jLabel12.setBounds(90, 430, 500, 30);

        jLayeredPane1.add(jPanelMoviesGenres, "card4");

        jPanelMoviesHighRated.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f));
        jPanelMoviesHighRated.setLayout(null);

        jLabelThirdGenre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelThirdGenre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThirdGenre.setText("Üçüncü türde en iyiler");
        jPanelMoviesHighRated.add(jLabelThirdGenre);
        jLabelThirdGenre.setBounds(10, 270, 640, 50);

        jListSelectedGenreThird.setBackground(new java.awt.Color(51, 51, 51));
        jListSelectedGenreThird.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jListSelectedGenreThird.setForeground(new java.awt.Color(255, 255, 255));
        jListSelectedGenreThird.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return listOfGenreSelectedThird.length; }
            public String getElementAt(int i) { return listOfGenreSelectedThird[i]; }
        });
        jListSelectedGenreThird.setFixedCellHeight(24);
        jScrollPane3.setViewportView(jListSelectedGenreThird);

        jPanelMoviesHighRated.add(jScrollPane3);
        jScrollPane3.setBounds(10, 340, 640, 60);

        jLabelFirstGenre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelFirstGenre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFirstGenre.setText("İlk türde en iyiler");
        jPanelMoviesHighRated.add(jLabelFirstGenre);
        jLabelFirstGenre.setBounds(10, 10, 630, 50);

        jListSelectedGenreFirst.setBackground(new java.awt.Color(51, 51, 51));
        jListSelectedGenreFirst.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jListSelectedGenreFirst.setForeground(new java.awt.Color(255, 255, 255));
        jListSelectedGenreFirst.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return listOfGenreSelectedFirst.length; }
            public String getElementAt(int i) { return listOfGenreSelectedFirst[i]; }
        });
        jListSelectedGenreFirst.setFixedCellHeight(24);
        jScrollPane4.setViewportView(jListSelectedGenreFirst);

        jPanelMoviesHighRated.add(jScrollPane4);
        jScrollPane4.setBounds(10, 60, 640, 60);

        jLabelSecondGenre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelSecondGenre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSecondGenre.setText("İkinci türde en iyiler");
        jPanelMoviesHighRated.add(jLabelSecondGenre);
        jLabelSecondGenre.setBounds(10, 140, 640, 50);

        jListSelectedGenreSecond.setBackground(new java.awt.Color(51, 51, 51));
        jListSelectedGenreSecond.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jListSelectedGenreSecond.setForeground(new java.awt.Color(255, 255, 255));
        jListSelectedGenreSecond.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return listOfGenreSelectedSecond.length; }
            public String getElementAt(int i) { return listOfGenreSelectedSecond[i]; }
        });
        jListSelectedGenreSecond.setFixedCellHeight(24);
        jScrollPane5.setViewportView(jListSelectedGenreSecond);

        jPanelMoviesHighRated.add(jScrollPane5);
        jScrollPane5.setBounds(10, 200, 640, 60);

        jButtonLinkToNetflixUI.setBackground(new java.awt.Color(153, 0, 0));
        jButtonLinkToNetflixUI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonLinkToNetflixUI.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLinkToNetflixUI.setText("NETFLIX'TE İZLEMEYE BAŞLA->");
        jButtonLinkToNetflixUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLinkToNetflixUIActionPerformed(evt);
            }
        });
        jPanelMoviesHighRated.add(jButtonLinkToNetflixUI);
        jButtonLinkToNetflixUI.setBounds(110, 430, 440, 80);

        jLayeredPane1.add(jPanelMoviesHighRated, "card5");

        jPanelNetflixUI.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.5f));
        jPanelNetflixUI.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Netflix'te ara: ");
        jPanelNetflixUI.add(jLabel11);
        jLabel11.setBounds(10, 30, 180, 40);

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanelNetflixUI.add(jTextFieldSearch);
        jTextFieldSearch.setBounds(200, 30, 420, 40);

        jTableProgrammes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableProgrammes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Programın Adı", "Programın Tipi", "Programın Türü", "Bölüm Sayısı", "Program Uzunluğu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProgrammes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProgrammesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProgrammes);

        jPanelNetflixUI.add(jScrollPane2);
        jScrollPane2.setBounds(60, 120, 550, 260);

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("*Aramanız büyük-küçük harf duyarlıdır.");
        jPanelNetflixUI.add(jLabel13);
        jLabel13.setBounds(80, 80, 500, 40);

        jButtonWatchMovies.setBackground(new java.awt.Color(153, 0, 0));
        jButtonWatchMovies.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonWatchMovies.setForeground(new java.awt.Color(255, 255, 255));
        jButtonWatchMovies.setText("İZLE");
        jButtonWatchMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWatchMoviesActionPerformed(evt);
            }
        });
        jPanelNetflixUI.add(jButtonWatchMovies);
        jButtonWatchMovies.setBounds(70, 410, 160, 90);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Derecelendir:");
        jPanelNetflixUI.add(jLabel14);
        jLabel14.setBounds(240, 420, 250, 70);

        jTextFieldRating.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jPanelNetflixUI.add(jTextFieldRating);
        jTextFieldRating.setBounds(510, 420, 100, 70);

        jLayeredPane1.add(jPanelNetflixUI, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldSignUpConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSignUpConfirmationActionPerformed
        // TODO add your handling code here:
        String password = String.valueOf(jPasswordFieldSignUpConfirmation.getPassword());
        System.out.println("Kayıt sayfasındaki Parola Tekrarı: " + password);
    }//GEN-LAST:event_jPasswordFieldSignUpConfirmationActionPerformed

    private void jButtonSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignInActionPerformed
        // TODO add your handling code here:
        System.out.println("Giriş sayfasındaki E-posta: " + jTextFieldMailSignIn.getText());
        String password = String.valueOf(jPasswordFieldSignIn.getPassword());
        System.out.println("Giriş sayfasındaki Parola: " + password);
        if ("".equals(jTextFieldMailSignIn.getText()) || "".equals(password)) {
            JOptionPane.showMessageDialog(null, "E-postanızı ya da parolanızı "
                    + "eksik girdiniz.\nLütfen tekrar deneyin.");
        } else {

            Connection connection = null;
            DbHelper dbHelper = new DbHelper();
            Statement statement = null;
            ResultSet resultSet;

            try {
                connection = dbHelper.getConnection();
                System.out.println("SQLite bağlandı");
                String sql = "select * from user where mail =\"" + jTextFieldMailSignIn.getText() + "\" LIMIT 1";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                int rowCount = 0;
                while (resultSet.next()) {
                    rowCount++;
                }
                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null, "Böyle bir e-posta yok,"
                            + " girilen e-postayı kontrol edin veya kayıt olun!");
                } else {
                    // eğer parola veritabanındaki parolaya eşit değilse mesaj bastır
                    //eşitse sisteme gir 
                    sql = "select * from user where mail =\"" + jTextFieldMailSignIn.getText() + "\" LIMIT 1";
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery(sql);
                    if (!resultSet.getString("password").equals(String.valueOf(jPasswordFieldSignIn.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Şifre yanlış, lütfen tekrar deneyin.");

                    } else {
                        JOptionPane.showMessageDialog(null, "Tebrikler, başarıyla Netflix'e giriş yaptın.");
                        //Kullanıcı yönetim arayüzüne geçiş yapacak
                        currentUser = new User(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("mail"),
                                resultSet.getString("password"),
                                resultSet.getString("date_of_birth"));
                        System.out.println("id: " + currentUser.getId()
                                + " name: " + currentUser.getName()
                                + " mail: " + currentUser.getMail()
                                + " password: " + currentUser.getPassword()
                                + " date_of_birth: " + currentUser.getDate_of_birth());
                        jPanelSignIn.setVisible(false);
                        jPanelNetflixUI.setVisible(true);
                        statement.close();
                        connection.close();
                    }
                }
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
                JOptionPane.showMessageDialog(null, "HATA: " + ex.getMessage());
            }

        }
    }//GEN-LAST:event_jButtonSignInActionPerformed

    private void jPasswordFieldSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSignInActionPerformed
        // TODO add your handling code here:
        String password = String.valueOf(jPasswordFieldSignIn.getPassword());
        System.out.println("Giriş sayfasındaki Parola: " + password);
    }//GEN-LAST:event_jPasswordFieldSignInActionPerformed

    private void jButtonLinkToSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLinkToSignUpActionPerformed
        // TODO add your handling code here:
        jPanelSignIn.setVisible(false);
        jPanelSignUp.setVisible(true);
    }//GEN-LAST:event_jButtonLinkToSignUpActionPerformed

    private void jPasswordFieldSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSignUpActionPerformed
        // TODO add your handling code here:
        String password = String.valueOf(jPasswordFieldSignUp.getPassword());
        System.out.println("Kayıt sayfasındaki Parola: " + password);
    }//GEN-LAST:event_jPasswordFieldSignUpActionPerformed

    private void jButtonLinkToSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLinkToSignInActionPerformed
        // TODO add your handling code here:
        jPanelSignUp.setVisible(false);
        jPanelSignIn.setVisible(true);
    }//GEN-LAST:event_jButtonLinkToSignInActionPerformed

    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUpActionPerformed
        // TODO add your handling code here:
        System.out.println("Kayıt sayfasındaki Kullanıcı Adı: " + jTextFieldUserName.getText());
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dateOfBirth = dateFormat.format(jDateChooserDateOfBirth.getDate());
            System.out.println("Kayıt sayfasındaki Doğum Tarihi: " + dateOfBirth);
        } catch (NullPointerException nullPointerException) {
            JOptionPane.showMessageDialog(null, "Lütfen doğum tarihinizi giriniz.");
        }
        System.out.println("Kayıt sayfasındaki E-posta: " + jTextFieldMailSignUp.getText());
        String password = String.valueOf(jPasswordFieldSignUp.getPassword());
        System.out.println("Kayıt sayfasındaki Parola : " + password);
        String passwordConfirmation = String.valueOf(jPasswordFieldSignUpConfirmation.getPassword());
        System.out.println("Kayıt sayfasındaki Parola Tekrarı: " + passwordConfirmation);

        if ("".equals(jTextFieldMailSignUp.getText()) || "".equals(password)
                || "".equals(jTextFieldUserName.getText())) {
            JOptionPane.showMessageDialog(null, "Kullanıcı adınızı, e-postanızı ya da"
                    + " parolanızı eksik girdiniz.\nLütfen tekrar deneyin.");
        } else if (!password.equals(passwordConfirmation)) {
            System.out.println("Parolalar aynı değil!");
            JOptionPane.showMessageDialog(null, "Parolalar aynı değil!");
        } else {
            //eğer e-posta daha önce alınmışsa hata ver
            //alınmamışsa kaydet ve diğer sayfaya geçmesine izin ver
            Connection connection = null;
            DbHelper dbHelper = new DbHelper();
            Statement statement = null;
            Statement statementUser = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet;
            ResultSet resultSetUser = null;

            try {
                connection = dbHelper.getConnection();
                System.out.println("SQLite bağlandı");
                String sql = "select * from user where mail =\"" + jTextFieldMailSignUp.getText() + "\" LIMIT 1";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                int rowCount = 0;
                while (resultSet.next()) {
                    rowCount++;
                }
                if (rowCount != 0) {
                    JOptionPane.showMessageDialog(null, "Bu e-posta adresi zaten alınmış"
                            + ", Lütfen farklı bir e-posta giriniz veya giriş yapmak için GERİ DÖN tuşuna basınız.");
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String dateOfBirth = dateFormat.format(jDateChooserDateOfBirth.getDate());
                    sql = "insert into user(name, mail, password, date_of_birth) values (?,?,?,?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, jTextFieldUserName.getText());
                    preparedStatement.setString(2, jTextFieldMailSignUp.getText());
                    preparedStatement.setString(3, String.valueOf(jPasswordFieldSignUp.getPassword()));
                    preparedStatement.setString(4, dateOfBirth);
                    preparedStatement.executeUpdate();
                    String sqlUser = "select * from user where mail =\"" + jTextFieldMailSignUp.getText() + "\" LIMIT 1";
                    statementUser = connection.createStatement();
                    resultSetUser = statementUser.executeQuery(sqlUser);
                    currentUser = new User(resultSetUser.getInt("id"),
                            resultSetUser.getString("name"),
                            resultSetUser.getString("mail"),
                            resultSetUser.getString("password"),
                            resultSetUser.getString("date_of_birth"));
                    System.out.println("id: " + currentUser.getId()
                            + " name: " + currentUser.getName()
                            + " mail: " + currentUser.getMail()
                            + " password: " + currentUser.getPassword()
                            + " date_of_birth: " + currentUser.getDate_of_birth());
                    JOptionPane.showMessageDialog(null, "Tebrikler başarıyla kayıt oldun.");
                    System.out.println("Tebrikler başarıyla kayıt oldun.");
                    statement.close();
                    connection.close();
                    jPanelSignUp.setVisible(false);
                    jPanelMoviesGenres.setVisible(true);

                }
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }

        }

    }//GEN-LAST:event_jButtonSignUpActionPerformed

    private void jTextFieldMailSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMailSignInActionPerformed
        // TODO add your handling code here:
        System.out.println("Giriş sayfasındaki E-posta: " + jTextFieldMailSignIn.getText());

    }//GEN-LAST:event_jTextFieldMailSignInActionPerformed

    private void jTextFieldMailSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMailSignUpActionPerformed
        // TODO add your handling code here:
        System.out.println("Kayıt sayfasındaki E-posta: " + jTextFieldMailSignUp.getText());
    }//GEN-LAST:event_jTextFieldMailSignUpActionPerformed

    private void jTextFieldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserNameActionPerformed
        // TODO add your handling code here:
        System.out.println("Kayıt ekranındaki Kullanıcı Adı: " + jTextFieldUserName.getText());
    }//GEN-LAST:event_jTextFieldUserNameActionPerformed

    private void jButtonLinkToMoviesHighRatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLinkToMoviesHighRatedActionPerformed
        // TODO add your handling code here:
        if (jListMovieGenres.getSelectedValuesList().size() != 3) {
            JOptionPane.showMessageDialog(null, "Lütfen üç tane tür seçiniz!");
        } else {

            for (int i = 0; i < jListMovieGenres.getSelectedValuesList().size(); i++) {
                listOfSelectedGenres[i]
                        = jListMovieGenres.getSelectedValuesList().get(i);
            }
            System.out.println("Seçilen film türleri: ");
            for (String listOfSelectedGenre : listOfSelectedGenres) {

                System.out.println(listOfSelectedGenre);
            }
            //Seçilen Türlere göre en iyi filmleri listelemek için db bağlantısı
            Connection connection = null;
            DbHelper dbHelper = new DbHelper();
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = dbHelper.getConnection();
                System.out.println("SQLite bağlandı");
                //listOfSelectedGenres[] 0,1,2 alınmalı
                String[] sql = new String[3];
                sql[0] = "SELECT program_name, avg(rating) from user_programme where program_name in(SELECT p.name FROM programme as p WHERE p.id in(SELECT gp.programme_id from genre_programme as gp WHERE gp.genre_id in(SELECT g.id from genre as g WHERE g.name = \"" + listOfSelectedGenres[0] + "\"))) GROUP by program_name ORDER BY avg(rating) DESC LIMIT 2;";
                sql[1] = "SELECT program_name, avg(rating) from user_programme where program_name in(SELECT p.name FROM programme as p WHERE p.id in(SELECT gp.programme_id from genre_programme as gp WHERE gp.genre_id in(SELECT g.id from genre as g WHERE g.name = \"" + listOfSelectedGenres[1] + "\"))) GROUP by program_name ORDER BY avg(rating) DESC LIMIT 2;";
                sql[2] = "SELECT program_name, avg(rating) from user_programme where program_name in(SELECT p.name FROM programme as p WHERE p.id in(SELECT gp.programme_id from genre_programme as gp WHERE gp.genre_id in(SELECT g.id from genre as g WHERE g.name = \"" + listOfSelectedGenres[2] + "\"))) GROUP by program_name ORDER BY avg(rating) DESC LIMIT 2;";

                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql[0]);
                int index = 0;
                jLabelFirstGenre.setText(listOfSelectedGenres[0]);
                while (resultSet.next()) {

                    listOfGenreSelectedFirst[index] = "Film: " + resultSet.getString("program_name")
                            + "   Puan: " + resultSet.getFloat("avg(rating)");
                    index++;
                }
                index = 0;
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql[1]);
                jLabelSecondGenre.setText(listOfSelectedGenres[1]);
                while (resultSet.next()) {

                    listOfGenreSelectedSecond[index] = "Film: " + resultSet.getString("program_name")
                            + "   Puan: " + resultSet.getFloat("avg(rating)");
                    index++;
                }
                index = 0;
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql[2]);
                jLabelThirdGenre.setText(listOfSelectedGenres[2]);
                while (resultSet.next()) {

                    listOfGenreSelectedThird[index] = "Film: " + resultSet.getString("program_name")
                            + "   Puan: " + resultSet.getFloat("avg(rating)");
                    index++;
                }
                index = 0;

                statement.close();//
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception exception) {
                System.out.println("Henüz böyle bir veri yok"); // Hata mesajı güzeltilecek

            }
            jPanelMoviesGenres.setVisible(false);
            jPanelMoviesHighRated.setVisible(true);
        }
    }//GEN-LAST:event_jButtonLinkToMoviesHighRatedActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        String searchKey = jTextFieldSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
        jTableProgrammes.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));

    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jButtonLinkToNetflixUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLinkToNetflixUIActionPerformed
        // TODO add your handling code here:
        System.out.println("NetflixUI açıldı.");
        System.out.println("id: " + currentUser.getId()
                + " name: " + currentUser.getName()
                + " mail: " + currentUser.getMail()
                + " password: " + currentUser.getPassword()
                + " date_of_birth: " + currentUser.getDate_of_birth());
        jPanelMoviesHighRated.setVisible(false);
        jPanelNetflixUI.setVisible(true);
    }//GEN-LAST:event_jButtonLinkToNetflixUIActionPerformed

    private void jTableProgrammesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProgrammesMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTableProgrammesMouseClicked

    private void jButtonWatchMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWatchMoviesActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTableProgrammes.getSelectedRow();
        String name;
        String type;
        String genre;
        String numberOfEpisodes;
        String length_of_programme;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(today);
        System.out.println("tarih: "+date);
        int rating;
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        Statement statementEpisodes = null;
        ResultSet resultSet;
        ResultSet resultSetEpisodes;
        PreparedStatement preparedStatement = null;
        try {
            name = model.getValueAt(jTableProgrammes.convertRowIndexToModel(selectedRowIndex), 0).toString();
            type = model.getValueAt(jTableProgrammes.convertRowIndexToModel(selectedRowIndex), 1).toString();
            genre = model.getValueAt(jTableProgrammes.convertRowIndexToModel(selectedRowIndex), 2).toString();
            numberOfEpisodes = model.getValueAt(jTableProgrammes.convertRowIndexToModel(selectedRowIndex), 3).toString();
            length_of_programme = model.getValueAt(jTableProgrammes.convertRowIndexToModel(selectedRowIndex), 4).toString();
            rating = Integer.parseInt(jTextFieldRating.getText());
            if (rating < 1 || rating > 10) {
                throw new ArithmeticException("Lütfen derecelendirmenizi 1-10 arasında yapınız");
            }
            connection = dbHelper.getConnection();
            String sql = "select * from user_programme where user_id=" + currentUser.getId()
                    + " and program_name=\"" + name + "\" LIMIT 1";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int rowCounter = 0;
            while (resultSet.next()) {
                rowCounter++;
            }
            if (rowCounter == 0) {
                String sqlInsert = "insert into user_programme(user_id,program_name,watching_date,watching_time,episode,rating)"
                        + "values(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sqlInsert);
                preparedStatement.setInt(1, currentUser.getId());
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, date);
                preparedStatement.setInt(4, Integer.valueOf(length_of_programme));
                preparedStatement.setInt(5, 1); // ilk bölümünü izliyor
                preparedStatement.setFloat(6, rating);
                preparedStatement.executeUpdate();
                System.out.println("user_programmeye kayıt eklendi.");
            } else {
                if ("Dizi".equals(type)) {
                    String sqlWatchedEpisodes = "select episode from user_programme where user_id=" + currentUser.getId()
                            + " and program_name=\"" + name + "\" LIMIT 1";
                    statementEpisodes = connection.createStatement();
                    resultSetEpisodes = statementEpisodes.executeQuery(sqlWatchedEpisodes);
                    int watched_episodes = resultSetEpisodes.getInt("episode");
                    if (watched_episodes >= Integer.valueOf(numberOfEpisodes)) {
                        throw new IllegalArgumentException("Zaten " + name + " dizisini bitirdin.");
                    } else {
                        watched_episodes++;
                        String sqlUpdate = "update user_programme set episode=" + watched_episodes + ",watching_date=" + date + ",rating=" + rating + " where user_id=? and program_name=?";
                        preparedStatement = connection.prepareStatement(sqlUpdate);
                        preparedStatement.setInt(1, currentUser.getId());
                        preparedStatement.setString(2, name);
                        preparedStatement.executeUpdate();
                        System.out.println("user_programme dizi kaydı güncellendi");
                    }
                } else {
                    String sqlUpdate = "update user_programme set rating=" + rating + ",watching_date=" + date + " where user_id=? and program_name=?";
                    preparedStatement = connection.prepareStatement(sqlUpdate);
                    preparedStatement.setInt(1, currentUser.getId());
                    preparedStatement.setString(2, name);
                    preparedStatement.executeUpdate();
                    System.out.println("user_programme film kaydı güncellendi");
                }
            }

            System.out.println("Program ismi : " + name + " Programın tipi: " + type
                    + " Programın türü: " + genre + " Bölüm sayısı: " + numberOfEpisodes
                    + " Program Uzunluğu: " + length_of_programme + " Derecelendirme: " + rating);
            statement.close();
            connection.close();
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "HATA: Lütfen tam sayı giriniz!");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            JOptionPane.showMessageDialog(null, "HATA: Lütfen izleyeceğiniz filmi seçiniz.");
        } catch (ArithmeticException arithmeticException) {
            JOptionPane.showMessageDialog(null, arithmeticException.getMessage());
        } catch (SQLException sqlException) {
            dbHelper.showErrorMessage(sqlException);
            if(sqlException.getMessage().equals("[SQLITE_BUSY]  The database file is locked (database is locked)")){
                JOptionPane.showMessageDialog(null, "Veritabanı bağlantısı kilitlendi, lütfen işleminizi birkaç saniye sonra tekrar ediniz.");
                //connection'u kapatınca düzeldi.
            }
                
        } catch (IllegalArgumentException illegalArgumentException) {
            JOptionPane.showMessageDialog(null, illegalArgumentException.getMessage());
        }

//        try {
//            connection = dbHelper.getConnection();
//            System.out.println("SQLite bağlandı");
//            String sql = "insert into user_programme(user_id,)"
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "Emre");
//            preparedStatement.setString(2, "Akduman");
//            preparedStatement.setString(3, "25-01-1993");
//            preparedStatement.executeUpdate();
//            System.out.println("Kayıt eklendi");
//        } catch (SQLException ex) {
//            dbHelper.showErrorMessage(ex);
//        }
    }//GEN-LAST:event_jButtonWatchMoviesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLinkToMoviesHighRated;
    private javax.swing.JButton jButtonLinkToNetflixUI;
    private javax.swing.JButton jButtonLinkToSignIn;
    private javax.swing.JButton jButtonLinkToSignUp;
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JButton jButtonWatchMovies;
    private com.toedter.calendar.JDateChooser jDateChooserDateOfBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFirstGenre;
    private javax.swing.JLabel jLabelSecondGenre;
    private javax.swing.JLabel jLabelThirdGenre;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jListMovieGenres;
    private javax.swing.JList<String> jListSelectedGenreFirst;
    private javax.swing.JList<String> jListSelectedGenreSecond;
    private javax.swing.JList<String> jListSelectedGenreThird;
    private javax.swing.JPanel jPanelMoviesGenres;
    private javax.swing.JPanel jPanelMoviesHighRated;
    private javax.swing.JPanel jPanelNetflixUI;
    private javax.swing.JPanel jPanelSignIn;
    private javax.swing.JPanel jPanelSignUp;
    private javax.swing.JPasswordField jPasswordFieldSignIn;
    private javax.swing.JPasswordField jPasswordFieldSignUp;
    private javax.swing.JPasswordField jPasswordFieldSignUpConfirmation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableProgrammes;
    private javax.swing.JTextField jTextFieldMailSignIn;
    private javax.swing.JTextField jTextFieldMailSignUp;
    private javax.swing.JTextField jTextFieldRating;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
