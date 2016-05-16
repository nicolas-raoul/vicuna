package cuploader.frames;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import cuploader.Data;
import static cuploader.Data.fSettings;
import static cuploader.Data.settings;
import cuploader.FileFilters;
import cuploader.License;
import cuploader.PFile;
import cuploader.Settings;
import cuploader.ServerMonitor;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import org.wikipedia.Wiki;

public final class Main extends javax.swing.JFrame
    implements DropTargetListener, PropertyChangeListener {

  Data data;
  ServerMonitor monitor;

  public final static String UPDATE_URL = "http://yarl.github.io/vicuna/download/latest.jar";
  public final static String HOMEPAGE_URL = "http://yarl.github.io/vicuna/";

  public Main(Data data) {

    this.data = data;

    Boolean sayHello = readSettings();
    Data.settings.initializeLocale();
    Data.text = java.util.ResourceBundle.getBundle("cuploader/text/messages", Data.settings.getLang());

    Data.initializeQuickTemplates();
    addWindowListener(exit);

    setComponentOrientation(Data.getComponentOrientation());
    initComponents();
    initLangMenu();

    new DropTarget(pFilesContainer, this);
    pFilesScroll.getVerticalScrollBar().setUnitIncrement(16);
    mEdit.setEnabled(false);
    mFileUploadSelect.setEnabled(false);
    mUpload.setEnabled(false);
    
    dropInfo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
    dropInfo.setForeground(new Color(230, 230, 230));

    //show
    setLocationRelativeTo(null);
    readPosition();
    setVisible(true);

    monitor = new ServerMonitor(lServerStatus);
    Data.settings.addPropertyChangeListener(monitor);
    Data.addPropertyChangeListener(monitor);

    Data.addPropertyChangeListener(this); // login, logout events
    Data.settings.addPropertyChangeListener(this); // lang event
    if (sayHello) { 
      EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          JOptionPane.showMessageDialog(rootPane, Data.text("hello"));
        }
      });
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    gView = new javax.swing.ButtonGroup();
    mShow = new javax.swing.JPopupMenu();
    mViewAll1 = new javax.swing.JRadioButtonMenuItem();
    mViewToUpload1 = new javax.swing.JRadioButtonMenuItem();
    mViewNotUpload1 = new javax.swing.JRadioButtonMenuItem();
    gLang = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jToolBar1 = new javax.swing.JToolBar();
    bLoadFiles = new javax.swing.JButton();
    jSeparator6 = new javax.swing.JToolBar.Separator();
    bLoadSession = new javax.swing.JButton();
    bSaveSession = new javax.swing.JButton();
    jSeparator7 = new javax.swing.JToolBar.Separator();
    bFileEditSelected = new javax.swing.JButton();
    bView = new javax.swing.JButton();
    jToolBar2 = new javax.swing.JToolBar();
    bLogin = new javax.swing.JButton();
    jSeparator8 = new javax.swing.JToolBar.Separator();
    bSettings = new javax.swing.JButton();
    bAbout = new javax.swing.JButton();
    pUserInfo = new javax.swing.JPanel();
    lUserInfo = new javax.swing.JLabel();
    lServer = new javax.swing.JLabel();
    lServerStatus = new javax.swing.JLabel();
    pDesc = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    pHelp = new javax.swing.JPanel();
    lHelp = new javax.swing.JLabel();
    pUpload = new javax.swing.JPanel();
    jToolBar4 = new javax.swing.JToolBar();
    bUpload = new javax.swing.JButton();
    lFileUpload = new javax.swing.JLabel();
    pFilesContainer = new javax.swing.JPanel();
    pFilesScroll = new javax.swing.JScrollPane();
    pFiles = new javax.swing.JPanel();
    lStartInfo = new javax.swing.JLabel();
    mMenu = new javax.swing.JMenuBar();
    mFile = new javax.swing.JMenu();
    mLoadFiles = new javax.swing.JMenuItem();
    jSeparator5 = new javax.swing.JPopupMenu.Separator();
    mLoadSession = new javax.swing.JMenuItem();
    mSaveSession = new javax.swing.JMenuItem();
    mCleanSession = new javax.swing.JMenuItem();
    jSeparator3 = new javax.swing.JPopupMenu.Separator();
    mLogin = new javax.swing.JMenuItem();
    mUpload = new javax.swing.JMenuItem();
    jSeparator4 = new javax.swing.JPopupMenu.Separator();
    mFileUploadSelect = new javax.swing.JMenu();
    mFileUploadSelectAll = new javax.swing.JMenuItem();
    mFileUploadSelectInv = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    mEnd = new javax.swing.JMenuItem();
    mRestart = new javax.swing.JMenuItem();
    mEdit = new javax.swing.JMenu();
    mUndo = new javax.swing.JMenuItem();
    mRedo = new javax.swing.JMenuItem();
    mFileSelectAll = new javax.swing.JMenuItem();
    mFileSelectInv = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    mFileSelectedToUpload = new javax.swing.JMenuItem();
    mFileEditSelected = new javax.swing.JMenuItem();
    mView = new javax.swing.JMenu();
    mViewAll = new javax.swing.JRadioButtonMenuItem();
    mViewToUpload = new javax.swing.JRadioButtonMenuItem();
    mViewNotUpload = new javax.swing.JRadioButtonMenuItem();
    mTools = new javax.swing.JMenu();
    mLang = new javax.swing.JMenu();
    mSettings = new javax.swing.JMenuItem();
    mHelp = new javax.swing.JMenu();
    mHelpOnline = new javax.swing.JMenuItem();
    mAbout = new javax.swing.JMenuItem();

    gView.add(mViewAll1);
    mViewAll1.setSelected(true);
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cuploader/text/messages"); // NOI18N
    mViewAll1.setText(bundle.getString("view-all")); // NOI18N
    mViewAll1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewAll1ActionPerformed(evt);
      }
    });
    mShow.add(mViewAll1);

    gView.add(mViewToUpload1);
    mViewToUpload1.setText(bundle.getString("view-toupload")); // NOI18N
    mViewToUpload1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewToUpload1ActionPerformed(evt);
      }
    });
    mShow.add(mViewToUpload1);

    gView.add(mViewNotUpload1);
    mViewNotUpload1.setText(bundle.getString("view-notupload")); // NOI18N
    mViewNotUpload1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewNotUpload1ActionPerformed(evt);
      }
    });
    mShow.add(mViewNotUpload1);

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("VicuñaUploader " + Data.version);
    setBackground(new java.awt.Color(255, 255, 255));
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cuploader/resources/logo.png")));
    setMinimumSize(new java.awt.Dimension(900, 600));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jToolBar1.setComponentOrientation(getComponentOrientation());
    jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
    jToolBar1.setFloatable(false);
    jToolBar1.setBorderPainted(false);

    bLoadFiles.setBackground(new java.awt.Color(255, 255, 255));
    bLoadFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-import.png"))); // NOI18N
    bLoadFiles.setToolTipText(bundle.getString("folder-read")); // NOI18N
    bLoadFiles.setBorderPainted(false);
    bLoadFiles.setFocusable(false);
    bLoadFiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bLoadFiles.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        loadFiles(evt);
      }
    });
    jToolBar1.add(bLoadFiles);
    jToolBar1.add(jSeparator6);

    bLoadSession.setBackground(new java.awt.Color(255, 255, 255));
    bLoadSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/blue-folder-open.png"))); // NOI18N
    bLoadSession.setToolTipText(bundle.getString("session-open")); // NOI18N
    bLoadSession.setBorderPainted(false);
    bLoadSession.setFocusable(false);
    bLoadSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bLoadSession.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bLoadSession.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bLoadSessionActionPerformed(evt);
      }
    });
    jToolBar1.add(bLoadSession);

    bSaveSession.setBackground(new java.awt.Color(255, 255, 255));
    bSaveSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/disk-black-24.png"))); // NOI18N
    bSaveSession.setToolTipText(bundle.getString("session-save")); // NOI18N
    bSaveSession.setBorderPainted(false);
    bSaveSession.setFocusable(false);
    bSaveSession.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bSaveSession.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bSaveSession.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bSaveSessionActionPerformed(evt);
      }
    });
    jToolBar1.add(bSaveSession);
    jToolBar1.add(jSeparator7);

    bFileEditSelected.setBackground(new java.awt.Color(255, 255, 255));
    bFileEditSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image-edit-24.png"))); // NOI18N
    bFileEditSelected.setToolTipText(bundle.getString("files-edit")); // NOI18N
    bFileEditSelected.setBorderPainted(false);
    bFileEditSelected.setFocusable(false);
    bFileEditSelected.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bFileEditSelected.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bFileEditSelected.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bFileEditSelectedActionPerformed(evt);
      }
    });
    jToolBar1.add(bFileEditSelected);

    bView.setBackground(new java.awt.Color(255, 255, 255));
    bView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/card-address-img-24.png"))); // NOI18N
    bView.setToolTipText(bundle.getString("view")); // NOI18N
    bView.setBorderPainted(false);
    bView.setFocusable(false);
    bView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bView.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bViewActionPerformed(evt);
      }
    });
    jToolBar1.add(bView);

    jToolBar2.setComponentOrientation(getComponentOrientation());
    jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
    jToolBar2.setFloatable(false);
    jToolBar2.setRollover(true);

    bLogin.setBackground(new java.awt.Color(255, 255, 255));
    bLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/user-24.png"))); // NOI18N
    bLogin.setToolTipText(bundle.getString("login")); // NOI18N
    bLogin.setBorderPainted(false);
    bLogin.setFocusable(false);
    bLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        logIn(evt);
      }
    });
    jToolBar2.add(bLogin);
    jToolBar2.add(jSeparator8);

    bSettings.setBackground(new java.awt.Color(255, 255, 255));
    bSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/switch-24.png"))); // NOI18N
    bSettings.setToolTipText(bundle.getString("settings")); // NOI18N
    bSettings.setBorderPainted(false);
    bSettings.setFocusable(false);
    bSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bSettings.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bSettingsActionPerformed(evt);
      }
    });
    jToolBar2.add(bSettings);

    bAbout.setBackground(new java.awt.Color(255, 255, 255));
    bAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/color-swatch-24.png"))); // NOI18N
    bAbout.setToolTipText(bundle.getString("help-about")); // NOI18N
    bAbout.setBorderPainted(false);
    bAbout.setFocusable(false);
    bAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bAbout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAboutActionPerformed(evt);
      }
    });
    jToolBar2.add(bAbout);

    pUserInfo.setComponentOrientation(getComponentOrientation());
    pUserInfo.setBackground(new java.awt.Color(255, 255, 255));
    pUserInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), bundle.getString("status"))); // NOI18N

    lUserInfo.setForeground(new java.awt.Color(102, 102, 102));
    lUserInfo.setHorizontalAlignment(Data.getOrientation(false));
    lUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/user.png"))); // NOI18N
    lUserInfo.setText(bundle.getString("status-unlogged")); // NOI18N
    lUserInfo.setHorizontalTextPosition(Data.getOrientation(true));

    lServer.setHorizontalAlignment(Data.getOrientation(false));
    lServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/server.png"))); // NOI18N
    lServer.setText(Data.settings.server);
    lServer.setHorizontalTextPosition(Data.getOrientation(true));

    lServerStatus.setHorizontalAlignment(Data.getOrientation(false));
    lServerStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/status-offline.png"))); // NOI18N
    lServerStatus.setText(bundle.getString("server-status")); // NOI18N
    lServerStatus.setHorizontalTextPosition(Data.getOrientation(true));

    javax.swing.GroupLayout pUserInfoLayout = new javax.swing.GroupLayout(pUserInfo);
    pUserInfo.setLayout(pUserInfoLayout);
    pUserInfoLayout.setHorizontalGroup(
      pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pUserInfoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lServerStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pUserInfoLayout.setVerticalGroup(
      pUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pUserInfoLayout.createSequentialGroup()
        .addComponent(lUserInfo)
        .addGap(18, 18, 18)
        .addComponent(lServer, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lServerStatus))
    );

    pDesc.setComponentOrientation(getComponentOrientation());
    pDesc.setBackground(new java.awt.Color(255, 255, 255));
    pDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

    jLabel1.setHorizontalAlignment(Data.getOrientation(false));
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter.png"))); // NOI18N
    jLabel1.setText("<html>" + Data.text("manual-1") + "</html>"); // NOI18N
    jLabel1.setHorizontalTextPosition(Data.getOrientation(true));

    jLabel2.setComponentOrientation(getComponentOrientation());
    jLabel2.setHorizontalAlignment(Data.getOrientation(false));
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-02.png"))); // NOI18N
    jLabel2.setText("<html>" + Data.text("manual-2") + "</html>"); // NOI18N
    jLabel2.setHorizontalTextPosition(Data.getOrientation(true));
    jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    jLabel4.setComponentOrientation(getComponentOrientation());
    jLabel4.setHorizontalAlignment(Data.getOrientation(false));
    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-03.png"))); // NOI18N
    jLabel4.setText("<html>" + Data.text("manual-3") + "</html>"); // NOI18N
    jLabel4.setHorizontalTextPosition(Data.getOrientation(true));
    jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    jLabel6.setHorizontalAlignment(Data.getOrientation(false));
    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-04.png"))); // NOI18N
    jLabel6.setText("<html>" + Data.text("manual-4") + "</html>"); // NOI18N
    jLabel6.setHorizontalTextPosition(Data.getOrientation(true));

    jLabel7.setHorizontalAlignment(Data.getOrientation(false));
    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/notification-counter-05.png"))); // NOI18N
    jLabel7.setText("<html>" + Data.text("manual-5") + "</html>"); // NOI18N
    jLabel7.setHorizontalTextPosition(Data.getOrientation(true));

    javax.swing.GroupLayout pDescLayout = new javax.swing.GroupLayout(pDesc);
    pDesc.setLayout(pDescLayout);
    pDescLayout.setHorizontalGroup(
      pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pDescLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(14, Short.MAX_VALUE))
    );
    pDescLayout.setVerticalGroup(
      pDescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pDescLayout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pHelp.setComponentOrientation(getComponentOrientation());
    pHelp.setBackground(new java.awt.Color(255, 255, 255));
    pHelp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
    pHelp.setToolTipText("");

    lHelp.setHorizontalAlignment(Data.getOrientation(false));
    lHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
    lHelp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    lHelp.setHorizontalTextPosition(Data.getOrientation(true));

    javax.swing.GroupLayout pHelpLayout = new javax.swing.GroupLayout(pHelp);
    pHelp.setLayout(pHelpLayout);
    pHelpLayout.setHorizontalGroup(
      pHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pHelpLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pHelpLayout.setVerticalGroup(
      pHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pHelpLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pUpload.setComponentOrientation(getComponentOrientation());
    pUpload.setBackground(new java.awt.Color(255, 255, 255));
    pUpload.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), bundle.getString("toupload"))); // NOI18N

    jToolBar4.setComponentOrientation(getComponentOrientation());
    jToolBar4.setBackground(new java.awt.Color(255, 255, 255));
    jToolBar4.setFloatable(false);
    jToolBar4.setRollover(true);

    bUpload.setBackground(new java.awt.Color(255, 255, 255));
    bUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/drive-upload-24.png"))); // NOI18N
    bUpload.setToolTipText(bundle.getString("upload")); // NOI18N
    bUpload.setBorderPainted(false);
    bUpload.setFocusable(false);
    bUpload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    bUpload.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    bUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bUploadActionPerformed(evt);
      }
    });
    jToolBar4.add(bUpload);

    lFileUpload.setHorizontalAlignment(Data.getOrientation(false));
    lFileUpload.setText("0 / 0 (0 MiB)");
    jToolBar4.add(lFileUpload);

    javax.swing.GroupLayout pUploadLayout = new javax.swing.GroupLayout(pUpload);
    pUpload.setLayout(pUploadLayout);
    pUploadLayout.setHorizontalGroup(
      pUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pUploadLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(17, Short.MAX_VALUE))
    );
    pUploadLayout.setVerticalGroup(
      pUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pUploadLayout.createSequentialGroup()
        .addGap(3, 3, 3)
        .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pFilesContainer.setBackground(new java.awt.Color(255, 255, 255));
    pFilesContainer.setLayout(new java.awt.GridBagLayout());

    pFilesScroll.setComponentOrientation(getComponentOrientation());
    pFilesScroll.setBackground(new java.awt.Color(255, 255, 255));
    pFilesScroll.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)), bundle.getString("files"))); // NOI18N
    pFilesScroll.setAutoscrolls(true);
    pFilesScroll.setMinimumSize(new java.awt.Dimension(100, 100));
    pFilesScroll.setPreferredSize(new java.awt.Dimension(100, 100));

    pFiles.setBackground(new java.awt.Color(255, 255, 255));
    pFiles.setMinimumSize(new java.awt.Dimension(300, 56));
    pFiles.setLayout(new java.awt.GridBagLayout());

    lStartInfo.setHorizontalAlignment(Data.getOrientation(false));
    lStartInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/light-bulb.png"))); // NOI18N
    lStartInfo.setText(bundle.getString("start-info")); // NOI18N
    lStartInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
    lStartInfo.setHorizontalTextPosition(Data.getOrientation(true));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
    pFiles.add(lStartInfo, gridBagConstraints);

    pFilesScroll.setViewportView(pFiles);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 583;
    gridBagConstraints.ipady = 395;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    pFilesContainer.add(pFilesScroll, gridBagConstraints);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pFilesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(pHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(pDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(pUserInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addComponent(pUpload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(pUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(pFilesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );

    mMenu.setComponentOrientation(getComponentOrientation());
    mMenu.setBorderPainted(false);

    mFile.setComponentOrientation(getComponentOrientation());
    mFile.setBackground(new java.awt.Color(230, 230, 230));
    mFile.setText(bundle.getString("file")); // NOI18N

    mLoadFiles.setComponentOrientation(getComponentOrientation());
    mLoadFiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
    mLoadFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/folder-import_1.png"))); // NOI18N
    mLoadFiles.setText(Data.text("folder-read")); // NOI18N
    mLoadFiles.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        loadFiles(evt);
      }
    });
    mFile.add(mLoadFiles);
    mFile.add(jSeparator5);

    mLoadSession.setComponentOrientation(getComponentOrientation());
    mLoadSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
    mLoadSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/blue-folder-open_1.png"))); // NOI18N
    mLoadSession.setText(bundle.getString("session-open")); // NOI18N
    mLoadSession.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mLoadSessionActionPerformed(evt);
      }
    });
    mFile.add(mLoadSession);

    mSaveSession.setComponentOrientation(getComponentOrientation());
    mSaveSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
    mSaveSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/disk-black.png"))); // NOI18N
    mSaveSession.setText(bundle.getString("session-save")); // NOI18N
    mSaveSession.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mSaveSessionActionPerformed(evt);
      }
    });
    mFile.add(mSaveSession);

    mCleanSession.setComponentOrientation(getComponentOrientation());
    mCleanSession.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
    mCleanSession.setText(bundle.getString("session-clear")); // NOI18N
    mCleanSession.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mCleanSessionActionPerformed(evt);
      }
    });
    mFile.add(mCleanSession);
    mFile.add(jSeparator3);

    mLogin.setComponentOrientation(getComponentOrientation());
    mLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_QUOTE, java.awt.event.InputEvent.CTRL_MASK));
    mLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/users.png"))); // NOI18N
    mLogin.setText(bundle.getString("login")); // NOI18N
    mLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        logIn(evt);
      }
    });
    mFile.add(mLogin);

    mUpload.setComponentOrientation(getComponentOrientation());
    mUpload.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
    mUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/drive-upload.png"))); // NOI18N
    mUpload.setText(bundle.getString("upload")); // NOI18N
    mUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mUploadActionPerformed(evt);
      }
    });
    mFile.add(mUpload);
    mFile.add(jSeparator4);

    mFileUploadSelect.setComponentOrientation(getComponentOrientation());
    mFileUploadSelect.setText(bundle.getString("files-to-upload")); // NOI18N

    mFileUploadSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    mFileUploadSelectAll.setText(bundle.getString("files-select-all")); // NOI18N
    mFileUploadSelectAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileUploadSelectAllActionPerformed(evt);
      }
    });
    mFileUploadSelect.add(mFileUploadSelectAll);

    mFileUploadSelectInv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
    mFileUploadSelectInv.setText(bundle.getString("files-inv")); // NOI18N
    mFileUploadSelectInv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileUploadSelectInvActionPerformed(evt);
      }
    });
    mFileUploadSelect.add(mFileUploadSelectInv);

    mFile.add(mFileUploadSelect);
    mFile.add(jSeparator1);

    mEnd.setComponentOrientation(getComponentOrientation());
    mEnd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
    mEnd.setText(bundle.getString("button-close")); // NOI18N
    mEnd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mEndActionPerformed(evt);
      }
    });
    mFile.add(mEnd);

    mRestart.setComponentOrientation(getComponentOrientation());
    mRestart.setText(bundle.getString("restart")); // NOI18N
    mRestart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mRestartActionPerformed(evt);
      }
    });
    mFile.add(mRestart);

    mMenu.add(mFile);

    mEdit.setComponentOrientation(getComponentOrientation());
    mEdit.setBackground(new java.awt.Color(230, 230, 230));
    mEdit.setText(bundle.getString("edit")); // NOI18N

    mUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
    mUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-transition.png"))); // NOI18N
    mUndo.setText(bundle.getString("undo")); // NOI18N
    mUndo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mUndoActionPerformed(evt);
      }
    });
    mEdit.add(mUndo);

    mRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
    mRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/arrow-transition-180.png"))); // NOI18N
    mRedo.setText(bundle.getString("redo")); // NOI18N
    mRedo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mRedoActionPerformed(evt);
      }
    });
    mEdit.add(mRedo);

    mFileSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
    mFileSelectAll.setText(bundle.getString("files-select-all")); // NOI18N
    mFileSelectAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileSelectAllActionPerformed(evt);
      }
    });
    mEdit.add(mFileSelectAll);

    mFileSelectInv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
    mFileSelectInv.setText(bundle.getString("files-inv")); // NOI18N
    mFileSelectInv.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileSelectInvActionPerformed(evt);
      }
    });
    mEdit.add(mFileSelectInv);
    mEdit.add(jSeparator2);

    mFileSelectedToUpload.setText(bundle.getString("files-select-to-upload")); // NOI18N
    mFileSelectedToUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileSelectedToUploadActionPerformed(evt);
      }
    });
    mEdit.add(mFileSelectedToUpload);

    mFileEditSelected.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
    mFileEditSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/image--pencil.png"))); // NOI18N
    mFileEditSelected.setText(bundle.getString("files-edit")); // NOI18N
    mFileEditSelected.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mFileEditSelectedActionPerformed(evt);
      }
    });
    mEdit.add(mFileEditSelected);

    mMenu.add(mEdit);

    mView.setBackground(new java.awt.Color(230, 230, 230));
    mView.setText(bundle.getString("view")); // NOI18N

    gView.add(mViewAll);
    mViewAll.setText(bundle.getString("view-all")); // NOI18N
    mViewAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewAllActionPerformed(evt);
      }
    });
    mView.add(mViewAll);

    gView.add(mViewToUpload);
    mViewToUpload.setText(bundle.getString("view-toupload")); // NOI18N
    mViewToUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewToUploadActionPerformed(evt);
      }
    });
    mView.add(mViewToUpload);

    gView.add(mViewNotUpload);
    mViewNotUpload.setText(bundle.getString("view-notupload")); // NOI18N
    mViewNotUpload.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mViewNotUploadActionPerformed(evt);
      }
    });
    mView.add(mViewNotUpload);

    mMenu.add(mView);

    mTools.setBackground(new java.awt.Color(230, 230, 230));
    mTools.setText(bundle.getString("tools")); // NOI18N

    mLang.setText(bundle.getString("settings-lang")); // NOI18N
    mTools.add(mLang);

    mSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
    mSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/switch.png"))); // NOI18N
    mSettings.setText(bundle.getString("settings")); // NOI18N
    mSettings.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mSettingsActionPerformed(evt);
      }
    });
    mTools.add(mSettings);

    mMenu.add(mTools);

    mHelp.setBackground(new java.awt.Color(230, 230, 230));
    mHelp.setText(bundle.getString("help")); // NOI18N

    mHelpOnline.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
    mHelpOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/lifebuoy.png"))); // NOI18N
    mHelpOnline.setText(bundle.getString("help-help")); // NOI18N
    mHelpOnline.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mHelpOnlineActionPerformed(evt);
      }
    });
    mHelp.add(mHelpOnline);

    mAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuploader/resources/color-swatch_1.png"))); // NOI18N
    mAbout.setText(bundle.getString("help-about")); // NOI18N
    mAbout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mAboutActionPerformed(evt);
      }
    });
    mHelp.add(mAbout);

    mMenu.add(mHelp);

    setJMenuBar(mMenu);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    /**
     * Reponse to the GUI Login/Logout button
     * When logged out opens log in window. When logged in log out right now.
     * @param evt 
     */
    private void logIn(ActionEvent evt) {
      if (Data.isLoggedIn()) {
        Data.wiki.logout();
        Data.setLoggedIn(false);
      } else {
        if (Data.fLogin == null) {
          Log.finer("Opening login window");
          Data.fLogin = new FLogin(data);
        } else {
          Log.finer("Login window exists");
        }
      }
    }

    private void mEndActionPerformed(java.awt.event.ActionEvent evt) {
      exit.windowClosing(null);
    }

    private void mUploadActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.filesUpload == 0) {
        JOptionPane.showMessageDialog(rootPane, Data.text("upload-selectfiles"), Data.text("uploading"), JOptionPane.ERROR_MESSAGE);
      } else {
        if (Data.wiki == null) {
          if (Data.fLogin == null) {
            Data.fLogin = new FLogin(data, true);
          } else {
            Data.fLogin.setVisible(true);
          }
        } else {
          if (Data.fUploadCheck == null) {
            Data.fUploadCheck = new FUploadCheck(data);
          } else {
            Data.fUploadCheck.setVisible(true);
          }
        }
      }
    }

    private void mFileUploadSelectAllActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile i : Data.getFiles()) {
        i.selectToUpload(true);
      }
    }

    private void mFileUploadSelectInvActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile i : Data.getFiles()) {
        i.selectToUpload(!i.toUpload);
      }
    }

    private void mFileEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.filesEdit > 0) {
        if (Data.fFileEdit == null) {
          Data.fFileEdit = new FFileEdit();
        } else {
          Data.fFileEdit.setVisible(true);
        }
      } else {
        JOptionPane.showMessageDialog(rootPane, Data.text("edit-selectfiles"), Data.text("editing"), JOptionPane.ERROR_MESSAGE);
      }
    }

    /**
     * Loading files to program. Opens file chooser.
     * @param evt 
     */
    private void loadFiles(ActionEvent evt) {
      //@TODO: translate: http://www.java-forums.org/new-java/13699-filechooser-ui.html
      JFileChooser ch = new JFileChooser();
        ch.setCurrentDirectory(new File(Data.settings.defaultDir));
        ch.setDialogTitle(Data.text("files-load"));
        ch.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        ch.setMultiSelectionEnabled(true);
        ch.setAcceptAllFileFilterUsed(false);
        ch.addChoosableFileFilter(FileFilters.images);
        ch.addChoosableFileFilter(FileFilters.documents);
        ch.addChoosableFileFilter(FileFilters.multimedia);
        ch.addChoosableFileFilter(FileFilters.all);

      if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        File[] selected = ch.getSelectedFiles();
        ArrayList<File> files = new ArrayList<File>();

        for (File f : selected) {
          if (Data.settings.loadSubdirectory) {
            addToArray(f);
          } else {
            if (f.isDirectory()) files.addAll(Arrays.asList(f.listFiles()));
            if (f.isFile()) files.add(f);
          }
        }
        
        // Sort files by last modification date
        Collections.sort(files, new Comparator<File>() {
          public int compare(File f1, File f2) {
            return Long.compare(f1.lastModified(), f2.lastModified());
          }
        });

        addImages(files);
        Data.settings.defaultDir = ch.getCurrentDirectory().getAbsolutePath();
      }
    }

    private void mFileSelectAllActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile i : Data.getFiles()) {
        i.selectToEdit(true);
      }
    }

    private void mFileSelectInvActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile i : Data.getFiles()) {
        i.selectToEdit(!i.toEdit);
      }
    }

    private void mFileSelectedToUploadActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile i : Data.getFiles())
        if (i.toEdit)
          i.selectToUpload(true);
    }
   
    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.fAbout == null) 
        Data.fAbout = new FAbout();
      else 
        Data.fAbout.setVisible(true);
      
    }

    private void mCleanSessionActionPerformed(java.awt.event.ActionEvent evt) {
      Object[] o = {Data.text("button-clear"), Data.text("button-cancel")};
      int n = JOptionPane.showOptionDialog(rootPane, Data.text("session-clear-q"), Data.text("session"),
              JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, o, o[0]);
      switch (n) {
        case 0: {
          Data.getFiles().clear();
          pFiles.removeAll();
          pFiles.repaint();

          mEdit.setEnabled(false);
          mFileUploadSelect.setEnabled(false);
          mUpload.setEnabled(false);

          Data.updateFileCounter();
          break;
        }
        case 1:
          break;
        default:
          break;
      }
    }

    private void mSettingsActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.fSettings == null) {
        Data.fSettings = new FSettings();
      } else {
        Data.fSettings.setVisible(true);
      }
    }

    private void mViewAllActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile f : Data.getFiles()) {
        f.setVisible(true);
      }
    }

    private void mViewToUploadActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile f : Data.getFiles()) {
        if (f.toUpload)
          f.setVisible(true);
        else
          f.setVisible(false);
      }
    }

    private void mViewNotUploadActionPerformed(java.awt.event.ActionEvent evt) {
      for (PFile f : Data.getFiles()) {
        if (f.toUpload)
          f.setVisible(false);
        else
          f.setVisible(true);
      }
    }

    private void bLoadSessionActionPerformed(java.awt.event.ActionEvent evt) {
      mLoadSessionActionPerformed(evt);
    }

    private void bSaveSessionActionPerformed(java.awt.event.ActionEvent evt) {
      mSaveSessionActionPerformed(evt);
    }

    private void bFileEditSelectedActionPerformed(java.awt.event.ActionEvent evt) {
      mFileEditSelectedActionPerformed(evt);
    }

    private void bSettingsActionPerformed(java.awt.event.ActionEvent evt) {
      mSettingsActionPerformed(evt);
    }

    private void bAboutActionPerformed(java.awt.event.ActionEvent evt) {
      mAboutActionPerformed(evt);
    }

    private void bViewActionPerformed(java.awt.event.ActionEvent evt) {
      mShow.show(bView, 0, 25);
    }

    private void mViewAll1ActionPerformed(java.awt.event.ActionEvent evt) {
      mViewAllActionPerformed(evt);
    }

    private void mViewToUpload1ActionPerformed(java.awt.event.ActionEvent evt) {
      mViewToUploadActionPerformed(evt);
    }

    private void mViewNotUpload1ActionPerformed(java.awt.event.ActionEvent evt) {
      mViewNotUploadActionPerformed(evt);
    }

    private void bUploadActionPerformed(java.awt.event.ActionEvent evt) {
      mUploadActionPerformed(evt);
    }

    private void mUndoActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.manager.canUndo()) {
        Data.manager.undo();
      }
    }

    private void mRedoActionPerformed(java.awt.event.ActionEvent evt) {
      if (Data.manager.canRedo()) {
        Data.manager.redo();
      }
    }

    private void mHelpOnlineActionPerformed(java.awt.event.ActionEvent evt) {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/yarl/vicuna/wiki#head"));
      } catch (URISyntaxException ex) {
        error(null, ex);
      } catch (IOException ex) {
        error(null, ex);
      }
    }

    private void mRestartActionPerformed(java.awt.event.ActionEvent evt) {
      ConfirmClose(true);
    }

  private void mSaveSessionActionPerformed(java.awt.event.ActionEvent evt) {
    saveSession();
  }

  private void mLoadSessionActionPerformed(java.awt.event.ActionEvent evt) {
    loadSession();
  }

  /**
   * Init
     *
   */
    //<editor-fold defaultstate="collapsed" desc=" Init ">
  /**
   * Reads session file
   *
   * @param stream input stream
   * @return string containing XML
   * @throws IOException
   * @source http://stackoverflow.com/a/12311740
   */
  private String readFile(String path) throws IOException {
    File f = new File(path);
    if (f.exists()) {
      BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
      
      String str;
      String text = "";
      while ((str = in.readLine()) != null) {
        text += str;
        text += System.getProperty("line.separator");
      } in.close();
      
      return text;
    } else {
      return "";
    }
  }

  /**
   * Checks if settings file exist
   *
   * @return true if exist
   */
  private Boolean readSettings() {
    Data.settings = new Settings();

    try {
      String text = readFile("settings.vicuna");

      if (!text.isEmpty()) {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        xstream.registerConverter(new MigrateOldLicense());
        xstream.processAnnotations(cuploader.Settings.class);
        xstream.processAnnotations(cuploader.QuickTemplate.class);
        xstream.processAnnotations(cuploader.DescSource.class);
        Data.settings = (Settings) xstream.fromXML(text);
      } else {
        return true;
      }
    } catch (IOException ex) {
      error("Could not understand the settings file", ex);
    }
    return false;
  }

  static class MigrateOldLicense extends EnumConverter {
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
      try {
        return super.unmarshal(reader, context);
      } catch (IllegalArgumentException e) {
        switch (Integer.parseInt(reader.getValue())) {
          case 1:
            return License.CC_BY_3;
          case 2:
            return License.CC_ZERO_1;
          case 3:
            return License.GFDL_CC_BY_SA_ALL;
          case 4:
            return License.GFDL_CC_BY_SA_3;
          case 5:
            return License.GFDL_CC_BY_3;
          case 6:
            return License.OTHER;
          default:
            return License.CC_BY_SA_3;
        }
      }
    }

    @Override
    public boolean canConvert(Class type) {
      return License.class.equals(type);
    }
  }

  /**
   * Adds language to menu (Tools -> Language)
   *
   * @param locale locale of language
   * @param name name of language, label of menu item
   * @since 1.19
   */
  private void addLangMenu(final Locale locale, final String name) {
    JRadioButtonMenuItem item = new JRadioButtonMenuItem(name);
    item.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Data.settings.setLang(locale);
      }
    });
    gLang.add(item);
    mLang.add(item);
  }

  private void initLangMenu() {
    addLangMenu(Locale.ENGLISH, "english (en)");
    addLangMenu(new Locale("ar"), "العربية (ar)");
    addLangMenu(new Locale("ast"), "asturianu (ast)");
    addLangMenu(new Locale("azb"), "ۆرکجه (azb)");
    addLangMenu(new Locale("be"), "беларуская (be)");
    addLangMenu(new Locale("bn"), "বাংলা (bn)");
    addLangMenu(new Locale("br"), "brezhoneg (br)");
    addLangMenu(new Locale("bs"), "bosanski (bs)");
    addLangMenu(new Locale("ca"), "català (ca)");
    addLangMenu(new Locale("cs", "CZ"), "česky (cs)");
    addLangMenu(new Locale("da"), "dansk (da)");
    addLangMenu(Locale.GERMAN, "Deutsch (de)");
    addLangMenu(new Locale("eo"), "Esperanto (eo)");
    addLangMenu(new Locale("es", "ES"), "español (es)");
    addLangMenu(new Locale("eu"), "euskara (eu)");
    addLangMenu(new Locale("fa"), "فارسی (fa)");
    addLangMenu(new Locale("fi"), "suomi (fi)");
    addLangMenu(new Locale("fo"), "føroyskt (fo)");
    addLangMenu(Locale.FRENCH, "français (fr)");
    addLangMenu(new Locale("gl"), "galego (gl)");
    addLangMenu(new Locale("gu"), "ગુજરાતી (gu)");
    addLangMenu(new Locale("he"), "עברית (he)");
    addLangMenu(new Locale("hi"), "हिन्दी (hi)");
    addLangMenu(new Locale("hu"), "magyar (hu)");
    addLangMenu(Locale.ITALY, "italiano (it)");
    addLangMenu(Locale.JAPANESE, "日本語 (ja)");
    addLangMenu(new Locale("ka"), "ქართული (ka)");
    addLangMenu(new Locale("kk-cyrl"), "қазақша (кирил) (kk-cyrl)");
    addLangMenu(new Locale("km"), "ភាសាខ្មែរ (km)");
    addLangMenu(new Locale("ko"), "한국어 (ko)");
    addLangMenu(new Locale("ksh"), "Ripoarisch (ksh)");
    addLangMenu(new Locale("ku-latn"), "Kurdî (latînî) (ku-latn)");
    addLangMenu(new Locale("lb"), "Lëtzebuergesch (lb)");
    addLangMenu(new Locale("lki"), "لەکی‎ (lki)");
    addLangMenu(new Locale("lt"), "lietuvių (lt)");
    addLangMenu(new Locale("mk"), "македонски (mk)");
    addLangMenu(new Locale("ml"), "മലയാളം (ml)");
    addLangMenu(new Locale("mn"), "монгол (mn)");
    addLangMenu(new Locale("mr"), "मराठी (mr)");
    addLangMenu(new Locale("ms"), "Bahasa Melayu (ms)");
    addLangMenu(new Locale("mzn"), "مازِرونی (mzn)");
    addLangMenu(new Locale("nl"), "Nederlands (nl)");
    addLangMenu(new Locale("oc"), "occitan (oc)");
    addLangMenu(new Locale("pa"), "ਪੰਜਾਬੀ (pa)");
    addLangMenu(new Locale("pl", "PL"), "polski (pl)");
    addLangMenu(new Locale("ps"), "پښتو (ps)");
    addLangMenu(new Locale("pt", "BR"), "português do Brasil (pt-BR)");
    addLangMenu(new Locale("pt", "PT"), "português (pt)");
    addLangMenu(new Locale("ru"), "русский (ru)");
    addLangMenu(new Locale("sa"), "संस्कृतम् (tr)");
    addLangMenu(new Locale("sk"), "slovenčina (sk)");
    addLangMenu(new Locale("sr-ec"), "српски (ћирилица)‎ (sr-ec)");
    addLangMenu(new Locale("sv", "SE"), "svenska (sv)");
    addLangMenu(new Locale("sw"), "Kiswahili (sw)");
    addLangMenu(new Locale("ta"), "தமிழ் (ta)");
    addLangMenu(new Locale("tr"), "Türkçe (tr)");
    addLangMenu(new Locale("tt"), "татарча (tt)");
    addLangMenu(new Locale("uk"), "українська (uk)");
    addLangMenu(new Locale("ur"), "اردو (ur)");
    addLangMenu(new Locale("xmf"), "მარგალური (xmf)");
    addLangMenu(new Locale("zh-hant"), "中文（繁體）‎ (zh-hant)");
    addLangMenu(new Locale("zh", "CN"), "中文（简体）‎ (zh)");
  }

  private void readPosition() {
    if (Data.settings.windowPosition != null && Data.settings.windowSize != null) {
      setBounds(Data.settings.windowPosition.x, Data.settings.windowPosition.y, Data.settings.windowSize.width, Data.settings.windowSize.height);
    }
  }

  private void checkVersion() {
    try {
      String v = new Wiki("commons.wikimedia.org").getPageText("User:Yarl/VicunaUploader/version").trim();
      if (Double.parseDouble(v) > Double.parseDouble(Data.version)) {
        Object[] o = {Data.text("button-autoupdate"), Data.text("button-download"), Data.text("button-cancel")};
        int n = JOptionPane.showOptionDialog(rootPane, "<html><body>" + Data.text("about-checkupdate-text") + " (<b>" + v + "</b>).</body></html>",
                Data.text("about-checkupdate"), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, o, o[0]);
        if (n == 0) {
          try {
            new FDownload(this, new URL(UPDATE_URL));
          } catch (MalformedURLException ex) {
            error("Cannot download: <" + UPDATE_URL + ">", ex);
          }
        } else if (n == 1) {
          try {
            Desktop.getDesktop().browse(new URI(HOMEPAGE_URL));
          } catch (URISyntaxException ex) {
            error("Cannot navigate to the home page: <" + HOMEPAGE_URL + ">", ex);
          } catch (IOException ex) {
            error("Cannot navigate to the home page: <" + HOMEPAGE_URL + ">", ex);
          }
        }
      }
    } catch (IOException ex) {
      error("Cannot check for the new version", ex);
    }
  }

    //</editor-fold>
  /**
   * Saving session
     *
   */
  //<editor-fold defaultstate="collapsed" desc=" Saving session ">
  private void saveSession() {
    JFileChooser ch = new JFileChooser();
    ch.setCurrentDirectory(new File(Data.settings.defaultDir));
    ch.setDialogTitle(Data.text("session-save"));
    ch.setAcceptAllFileFilterUsed(false);
    ch.addChoosableFileFilter(FileFilters.session);
    ch.setSelectedFile(new File(Data.settings.defaultDir, "session"));

    if (ch.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      File file;

      if (ch.getSelectedFile().getAbsolutePath().endsWith(".xml")) {
        file = new File(ch.getSelectedFile().getAbsolutePath());
      } else {
        file = new File(ch.getSelectedFile().getAbsolutePath() + ".xml");
      }

      //System.out.println(file);
      if (!file.exists()) {
        try {
          file = new File(file.getAbsoluteFile() + "");
          file.createNewFile();
          //boolean result = SaveSession(file);
          boolean result = saveSessionFile(file);
          if (result) {
            JOptionPane.showMessageDialog(rootPane, Data.text("session-save-success"), Data.text("session-save"), JOptionPane.INFORMATION_MESSAGE);
          }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(rootPane, Data.text("error") + ": " + ex.toString());
          error(null, ex);
        }
      } else {
        int dialog = JOptionPane.showConfirmDialog(rootPane, Data.text("session-save-exist"));
        if (dialog == 0) {
          boolean result = saveSessionFile(file);
          if (result) {
            JOptionPane.showMessageDialog(rootPane, Data.text("session-save-success"));
          }
        }
      }
    }
  }

  private boolean saveSessionFile(File f) {
    try {
      XStream xstream = new XStream(new DomDriver("UTF-8"));
      xstream.processAnnotations(cuploader.Settings.class);
      xstream.processAnnotations(cuploader.QuickTemplate.class);
      xstream.processAnnotations(cuploader.DescSource.class);
      xstream.registerConverter(new MapEntryConverter());

      String xml = xstream.toXML(settings);
      xml += xstream.toXML(Data.getFilesXML());

      try {
        Writer writer = new OutputStreamWriter(new FileOutputStream(f), Charset.forName("UTF-8"));
        xstream.toXML(settings, writer);
        xstream.toXML(Data.getFilesXML(), writer);

        return true;
      } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(fSettings, e.getMessage());
        System.err.println("Error: " + e.getMessage());
        return false;
      }
    } catch (HeadlessException ex) {
      error(null, ex);
      return false;
    }
  }
    //</editor-fold>

  /**
   * Loading session
     *
   */
  //<editor-fold defaultstate="collapsed" desc=" Loading session ">
  /**
   * Reads session
   */
  private void loadSession() {
    JFileChooser ch = new JFileChooser();
    ch.setCurrentDirectory(new File(Data.settings.defaultDir));
    ch.setDialogTitle(Data.text("session-load"));
    ch.setAcceptAllFileFilterUsed(false);
    ch.setMultiSelectionEnabled(false);
    ch.addChoosableFileFilter(FileFilters.session);

    if (ch.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      if (ch.getSelectedFile().isFile()) {
        loadSessionFile2(ch.getSelectedFile());
      } else {
        JOptionPane.showMessageDialog(rootPane, Data.text("session-load-error"), Data.text("session-load"), JOptionPane.ERROR_MESSAGE, null);
      }
    }
  }

class Comment {
    long id;
    String desc;
}

 class Comments {
    List<Comment> comments = new ArrayList<Comment>();
}
  
  private boolean loadSessionFile2(File f) {
    try {
      String text = readFile(f.getAbsolutePath());
      int stop = text.indexOf("<list>");
      String settings = text.substring(0,stop);
      String files = text.substring(stop);
      
      //System.out.println(settings);
      //System.out.println(" ");
      //System.out.println(files);
      
      if (!settings.isEmpty()) {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        xstream.processAnnotations(cuploader.Settings.class);
        xstream.processAnnotations(cuploader.QuickTemplate.class);
        xstream.processAnnotations(cuploader.DescSource.class);
        Data.settings = (Settings) xstream.fromXML(settings);
      }
      
      if (!files.isEmpty()) {
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        xstream.registerConverter(new MapEntryConverter());

        try {
          @SuppressWarnings("unchecked")
          ArrayList<Map<String,String>> elements = (ArrayList<Map<String,String>>) xstream.fromXML(files);
          //System.out.println(elements);
          new FFileLoading(elements, true);
          
          //new FFileLoading(fPath, fEdit, fUpload, fName, fDate, fDesc, fCoor, fCats);
          //lStartInfo.setVisible(false);
          //mEdit.setEnabled(true);
          //mFileUploadSelect.setEnabled(true);
          //mUpload.setEnabled(true);
        } catch (ClassCastException ex) {
          error("Bad session file format", ex);
          return false;
        }
      }
      if (Data.settings.permission == null) {
        Data.settings.permission = "";
      }
      
    } catch (IOException ex) {
      error(null, ex);
      return false;
    }
    return true;
  }
  
  /**
   * Reads directory and/or files to upload, send list of files to 'loading
   * frame'.
   * @param files array of selected directories/files
   * @return true if ok
   */
  public synchronized boolean addImages(ArrayList<File> files) {
    if (!files.isEmpty()) {
      ArrayList<File> vector = new ArrayList<File>();

      for (File f : files) {
        if (f.isFile()) {
          String name = f.getName();
          String ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();

          if (FileFilters.AllFilter.isMatching(ext)) {
            boolean dupe = false;
            for (PFile ff : Data.getFiles()) {
              if (ff.file.equals(f)) {
                dupe = true;
                break;
              }
            }
            if (!dupe) vector.add(f);
          }
        }
      }

      if (vector.isEmpty()) {
        JOptionPane.showMessageDialog(rootPane, Data.text("loading-nofiles"), Data.text("loading"), JOptionPane.INFORMATION_MESSAGE);
        return false;
      } else {
        new FFileLoading(vector);
        lStartInfo.setVisible(false);
        mEdit.setEnabled(true);
        mFileUploadSelect.setEnabled(true);
        mUpload.setEnabled(true);
        return true;
      }
    } else {
      JOptionPane.showMessageDialog(rootPane, Data.text("loading-nofiles"), Data.text("loading"), JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
  }

  /**
   * Closing
     *
   */
    //<editor-fold defaultstate="collapsed" desc=" Closing ">
  WindowListener exit = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent evt) {
      if (Data.settings.askQuit) {
        ConfirmClose(false);
      } else {
        Close();
      }
    }
  };

  /*
   * 'Are you sure' window
   */
  public void ConfirmClose(boolean restart) {
    Object[] options = {Data.text("button-close"), Data.text("button-save&close"), Data.text("button-cancel")};
    int n = JOptionPane.showOptionDialog(rootPane, Data.text("quit-confirm"), Data.text("end"),
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    switch (n) {
      case 0: { //close
        if (restart) {
          Restart();
        }
        Close();
        break;
      }
      case 1: { //save 'n' close
        mSaveSessionActionPerformed(new ActionEvent(mFile, 0, null));
        if (restart) {
          Restart();
        }
        Close();
        break;
      }
      case 2: //cancel
        break;
      default:
        break;
    }
  }

  void Close() {
    Data.settings.windowPosition = getLocation();
    Data.settings.windowSize = getSize();
    Data.saveSettings();
    Data.destroyQuickTemplates();
    try {
      Thread.sleep(500);
    } catch (InterruptedException ex) {
    }
    dispose();
  }

  void Restart() {
    try {
      final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
      final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

      /* is it a jar file? */
      if (!currentJar.getName().endsWith(".jar")) {
        return;
      }

      /* Build command: java -jar application.jar */
      final ArrayList<String> command = new ArrayList<String>();
      command.add(javaBin);
      command.add("-jar");
      command.add(currentJar.getPath());

      final ProcessBuilder builder = new ProcessBuilder(command);
      builder.start();
    } catch (IOException ex) {
      error(null, ex);
    } catch (URISyntaxException ex) {
      error(null, ex);
    }
  }
    //</editor-fold>

  /**
   * Changes language
   *
   * @param lang target locale
   */
  private void changeLang(Locale lang) {
    Data.saveSettings();

    Object[] o = {Data.text("button-restart"), Data.text("button-ok")};
    int n = JOptionPane.showOptionDialog(rootPane, Data.text("settings-lang-info"),
            Data.text("settings-lang"), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, o, o[0]);
    if (n == 0) {
      if (Data.settings.askQuit) {
        ConfirmClose(true);
      } else {
        Restart();
        Close();
      }
    }
  }

  public static void main(String args[]) {
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
    try {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException ex) {
        error(null, ex);
      } catch (InstantiationException ex) {
        error(null, ex);
      } catch (IllegalAccessException ex) {
        error(null, ex);
      }
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      error(null, ex);
    }
        //</editor-fold>

    //final JFrame frame = new Main(version, date);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAbout;
  private javax.swing.JButton bFileEditSelected;
  private javax.swing.JButton bLoadFiles;
  private javax.swing.JButton bLoadSession;
  public static javax.swing.JButton bLogin;
  private javax.swing.JButton bSaveSession;
  private javax.swing.JButton bSettings;
  private javax.swing.JButton bUpload;
  private javax.swing.JButton bView;
  private javax.swing.ButtonGroup gLang;
  private javax.swing.ButtonGroup gView;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JPopupMenu.Separator jSeparator3;
  private javax.swing.JPopupMenu.Separator jSeparator4;
  private javax.swing.JPopupMenu.Separator jSeparator5;
  private javax.swing.JToolBar.Separator jSeparator6;
  private javax.swing.JToolBar.Separator jSeparator7;
  private javax.swing.JToolBar.Separator jSeparator8;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JToolBar jToolBar2;
  private javax.swing.JToolBar jToolBar4;
  public static javax.swing.JLabel lFileUpload;
  public static javax.swing.JLabel lHelp;
  public static javax.swing.JLabel lServer;
  private javax.swing.JLabel lServerStatus;
  private javax.swing.JLabel lStartInfo;
  public static javax.swing.JLabel lUserInfo;
  private javax.swing.JMenuItem mAbout;
  private javax.swing.JMenuItem mCleanSession;
  private javax.swing.JMenu mEdit;
  private javax.swing.JMenuItem mEnd;
  private javax.swing.JMenu mFile;
  private javax.swing.JMenuItem mFileEditSelected;
  private javax.swing.JMenuItem mFileSelectAll;
  private javax.swing.JMenuItem mFileSelectInv;
  private javax.swing.JMenuItem mFileSelectedToUpload;
  private javax.swing.JMenu mFileUploadSelect;
  private javax.swing.JMenuItem mFileUploadSelectAll;
  private javax.swing.JMenuItem mFileUploadSelectInv;
  private javax.swing.JMenu mHelp;
  private javax.swing.JMenuItem mHelpOnline;
  private javax.swing.JMenu mLang;
  private javax.swing.JMenuItem mLoadFiles;
  private javax.swing.JMenuItem mLoadSession;
  public static javax.swing.JMenuItem mLogin;
  private javax.swing.JMenuBar mMenu;
  private javax.swing.JMenuItem mRedo;
  private javax.swing.JMenuItem mRestart;
  private javax.swing.JMenuItem mSaveSession;
  private javax.swing.JMenuItem mSettings;
  private javax.swing.JPopupMenu mShow;
  private javax.swing.JMenu mTools;
  private javax.swing.JMenuItem mUndo;
  private javax.swing.JMenuItem mUpload;
  private javax.swing.JMenu mView;
  private javax.swing.JRadioButtonMenuItem mViewAll;
  private javax.swing.JRadioButtonMenuItem mViewAll1;
  private javax.swing.JRadioButtonMenuItem mViewNotUpload;
  private javax.swing.JRadioButtonMenuItem mViewNotUpload1;
  private javax.swing.JRadioButtonMenuItem mViewToUpload;
  private javax.swing.JRadioButtonMenuItem mViewToUpload1;
  private javax.swing.JPanel pDesc;
  public static javax.swing.JPanel pFiles;
  private javax.swing.JPanel pFilesContainer;
  private javax.swing.JScrollPane pFilesScroll;
  private javax.swing.JPanel pHelp;
  private javax.swing.JPanel pUpload;
  private javax.swing.JPanel pUserInfo;
  // End of variables declaration//GEN-END:variables

  private JLabel dropInfo = new JLabel(Data.text("start-dropinfo"));
  
  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    java.util.logging.Logger.getLogger(Main.class.getName())
      .log(java.util.logging.Level.FINEST, "property changed: <" + evt.getPropertyName() + ">", evt);
    if (evt.getPropertyName() == "loggedIn") {
      if ((Boolean)evt.getNewValue()) {
        displayHelloMessage();
      } else {
        userLoggedOff();
      } 
    }
    if (evt.getPropertyName() == "first-time") {
    }
    if (evt.getPropertyName() == "lang") {
      //changeLang((Locale)evt.getNewValue());
    }
  }

  public void displayHelloMessage() {
    lUserInfo.setText("<html>" + Data.text("status-hello") + ", <b>" + Data.settings.username + "</b>!</html>");
    lUserInfo.setForeground(Color.BLACK);
    mLogin.setText(Data.text("logoff"));
    lServer.setText(Data.settings.server);
  }

  public void userLoggedOff() {
    lUserInfo.setText(Data.text("status-unlogged"));
    lUserInfo.setForeground(new Color(102, 102, 102));
    mLogin.setText(Data.text("login"));
  }
  
  /**
   * Drag & drop
   *
   * @see
   * <a href="http://www.java-tips.org/java-se-tips/javax.swing/how-to-implement-drag-drop-functionality-in-your-applic.html">How to implement drag'n'drop functionality</a>
   */
  @Override
  public void dragEnter(DropTargetDragEvent dtde) {
    pFilesContainer.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
            BorderFactory.createLineBorder(new Color(230, 230, 230), 5)));
    
    pFilesContainer.add(dropInfo);
    pFilesScroll.setVisible(false);
  }

  @Override
  public void dragOver(DropTargetDragEvent dtde) {
  }

  @Override
  public void dropActionChanged(DropTargetDragEvent dtde) {
    pFilesContainer.setBorder(BorderFactory.createEmptyBorder());
    pFilesContainer.remove(dropInfo);
    pFilesScroll.setVisible(true);
  }

  @Override
  public void dragExit(DropTargetEvent dte) {
    pFilesContainer.setBorder(BorderFactory.createEmptyBorder());
    pFilesContainer.remove(dropInfo);
    pFilesScroll.setVisible(true);
  }

  public ArrayList<File> array;

  public void addToArray(File f) {
    if (f.isFile()) {
      array.add(f);
    }

    if (f.isDirectory()) {
      File[] files = f.listFiles();
      for (File fi : files) {
        addToArray(fi);
      }
    }
  }

  @Override
  public void drop(DropTargetDropEvent dtde) {
    pFilesContainer.setBorder(BorderFactory.createEmptyBorder());
    pFilesContainer.remove(dropInfo);
    pFilesScroll.setVisible(true);
    try {
      Transferable tr = dtde.getTransferable();
      DataFlavor[] flavors = tr.getTransferDataFlavors();
      for (int i = 0; i < flavors.length; i++) {
        //System.out.println("Possible flavor: " + flavors[i].getMimeType());
        if (flavors[i].isFlavorJavaFileListType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          array = new ArrayList<File>();
          @SuppressWarnings("unchecked")
          List<File> list = (List<File>) tr.getTransferData(flavors[i]);

          for (File f : list) {
            if (Data.settings.loadSubdirectory) {
              addToArray(f);
            } else {
              if (f.isDirectory()) {
                array.addAll(Arrays.asList(f.listFiles()));
              }
              if (f.isFile()) {
                array.add(f);
              }
            }
          }
          addImages(array);
          dtde.dropComplete(true);
          return;
        } else if (flavors[i].isRepresentationClassInputStream()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          dtde.dropComplete(true);
          return;
        }
      }
      dtde.rejectDrop();
    } catch (Exception e) {
      dtde.rejectDrop();
    }
  }

  protected static void error(String s1, Object s2) {
    Log.log(Level.SEVERE, s1, s2);
  }

  protected static java.util.logging.Logger Log = java.util.logging.Logger.getLogger(Main.class.getName());

  static final long serialVersionUID = -4314089010092936678L;
}

class MapEntryConverter implements Converter {
  
  @SuppressWarnings("rawtypes")
  public boolean canConvert(Class clazz) {
    return AbstractMap.class.isAssignableFrom(clazz);
  }
  
  public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    @SuppressWarnings("unchecked")
    AbstractMap<String, String> map = (AbstractMap<String, String>) value;
    for (Entry<String, String> entry : map.entrySet()) {
      writer.startNode(entry.getKey().toString());
      writer.setValue(entry.getValue().toString());
      writer.endNode();
    }
  }
  
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    Map<String, String> map = new HashMap<String, String>();

    while (reader.hasMoreChildren()) {
      reader.moveDown();
      map.put(reader.getNodeName(), reader.getValue());
      reader.moveUp();
    }
    return map;
  }
}
