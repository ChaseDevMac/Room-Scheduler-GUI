
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chase
 */
public class MainFrame extends javax.swing.JFrame {

    private JOptionPane roomModificationOptionPane;
    private JOptionPane reservationOptionPane;
    private JOptionPane dateModificationOptionPane;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        // Load the combo boxes with data
        rebuildFacultyComboBoxes();
        rebuildDateComboBoxes();
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
        rebuildRoomsStatusTable();
        rebuildDatesStatusTable();
        rebuildFacultyStatusTable();
    }

    public void rebuildFacultyComboBoxes() {
        reserveFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(Faculty.getFacultyList().toArray()));
        filterByFacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel(Faculty.getFacultyList().toArray()));
    }

    public void rebuildDateComboBoxes() {
        reserveDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(Dates.getDatesList().toArray()));
        filterByDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(Dates.getDatesList().toArray()));
    }

    public void rebuildReservationStatusTable() {
        Object[] columnHeaders = {"Faculty", "Room Number", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel reservationTableModel = new DefaultTableModel();
        reservationTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<ReservationEntry> reservationTableRows = ReservationQueries.getAllReservations();

        for (ReservationEntry currentEntry : reservationTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getRoomNumber(), currentEntry.getReservationDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            reservationTableModel.addRow(rowData);
        }

        reservationStatusTable.setModel(reservationTableModel);
    }

    public void rebuildReservationStatusTable(Date filterDate) {
        Object[] columnHeaders = {"Faculty", "Room Number", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel reservationTableModel = new DefaultTableModel();
        reservationTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<ReservationEntry> reservationTableRows = ReservationQueries.getReservationByDate(filterDate);

        for (ReservationEntry currentEntry : reservationTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getRoomNumber(), currentEntry.getReservationDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            reservationTableModel.addRow(rowData);
        }

        reservationStatusTable.setModel(reservationTableModel);
    }

    public void rebuildReservationStatusTable(String filterFaculty) {
        Object[] columnHeaders = {"Faculty", "Room Number", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel reservationTableModel = new DefaultTableModel();
        reservationTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<ReservationEntry> reservationTableRows = ReservationQueries.getReservationByFaculty(filterFaculty);

        for (ReservationEntry currentEntry : reservationTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getRoomNumber(), currentEntry.getReservationDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            reservationTableModel.addRow(rowData);
        }

        reservationStatusTable.setModel(reservationTableModel);
    }

    public void rebuildWaitlistStatusTable() {
        Object[] columnHeaders = {"Faculty", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel waitlistTableModel = new DefaultTableModel();
        waitlistTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<WaitlistEntry> waitlistTableRows = WaitlistQueries.getAllWaitlistEntries();

        for (WaitlistEntry currentEntry : waitlistTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getWaitlistDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            waitlistTableModel.addRow(rowData);
        }

        waitlistStatusTable.setModel(waitlistTableModel);
    }

    public void rebuildWaitlistStatusTable(Date filterDate) {
        Object[] columnHeaders = {"Faculty", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel waitlistTableModel = new DefaultTableModel();
        waitlistTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<WaitlistEntry> waitlistTableRows = WaitlistQueries.getWaitlistByDate(filterDate);

        for (WaitlistEntry currentEntry : waitlistTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getWaitlistDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            waitlistTableModel.addRow(rowData);
        }

        waitlistStatusTable.setModel(waitlistTableModel);
    }

    public void rebuildWaitlistStatusTable(String filterFaculty) {
        Object[] columnHeaders = {"Faculty", "Date", "Number of Seats", "Timestamp"};
        DefaultTableModel waitlistTableModel = new DefaultTableModel();
        waitlistTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<WaitlistEntry> waitlistTableRows = WaitlistQueries.getWaitlistByFaculty(filterFaculty);

        for (WaitlistEntry currentEntry : waitlistTableRows) {
            Object[] rowData = {currentEntry.getFacultyName(), currentEntry.getWaitlistDate(), currentEntry.getNumberOfSeats(), currentEntry.getReservationTimestamp()};
            waitlistTableModel.addRow(rowData);
        }

        waitlistStatusTable.setModel(waitlistTableModel);
    }

    public void rebuildRoomsStatusTable() {
        Object[] columnHeaders = {"Room", "Number of Seats"};
        DefaultTableModel roomTableModel = new DefaultTableModel();
        roomTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<RoomEntry> roomTableRows = RoomQueries.getAllRooms();

        for (RoomEntry currentEntry : roomTableRows) {
            Object[] rowData = {currentEntry.getRoomNumber(), currentEntry.getNumberOfSeats()};
            roomTableModel.addRow(rowData);
        }

        roomStatusTable.setModel(roomTableModel);
    }

    public void rebuildDatesStatusTable() {
        Object[] columnHeaders = {"Date"};
        DefaultTableModel dateTableModel = new DefaultTableModel();
        dateTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<Date> dateTableRows = Dates.getDatesList();

        for (Date currentEntry : dateTableRows) {
            Object[] rowData = {currentEntry};
            dateTableModel.addRow(rowData);
        }

        dateStatusTable.setModel(dateTableModel);
    }

    public void rebuildFacultyStatusTable() {
        Object[] columnHeaders = {"Faculty Name"};
        DefaultTableModel facultyTableModel = new DefaultTableModel();
        facultyTableModel.setColumnIdentifiers(columnHeaders);
        ArrayList<String> dateTableRows = Faculty.getFacultyList();

        for (String currentEntry : dateTableRows) {
            Object[] rowData = {currentEntry};
            facultyTableModel.addRow(rowData);
        }

        facultyStatusTable.setModel(facultyTableModel);
    }

    public void addReservationsFromWaitlist() {

        ArrayList<WaitlistEntry> waitlistList = WaitlistQueries.getAllWaitlistEntries();

        for (WaitlistEntry currentEntry : waitlistList) {
            ArrayList<String> possibleRooms = RoomQueries.getAllPossibleRooms(currentEntry.getNumberOfSeats());
            ArrayList<String> reservedRooms = ReservationQueries.getRoomsReservedByDate(currentEntry.getWaitlistDate());
            boolean reservationAdded = false;
            for (String room : possibleRooms) {
                if (!reservedRooms.contains(room)) {
                    ReservationQueries.addReservationEntry(currentEntry, room);
                    reservationAdded = true;
                    break;
                }
            }
            if (reservationAdded) {
                WaitlistQueries.deleteWaitlistEntry(currentEntry.getFacultyName(), currentEntry.getWaitlistDate());
            }
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

        roomModificationDialog = new javax.swing.JDialog();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addFacultyTextField = new javax.swing.JTextField();
        addFacultySubmitButton = new javax.swing.JButton();
        addFacultyStatusLabel = new javax.swing.JLabel();
        fireFacultyStatusLabel = new javax.swing.JLabel();
        fireFacultyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        facultyStatusTable = new javax.swing.JTable();
        roomPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        roomNumberTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        roomCapacityTextField = new javax.swing.JTextField();
        addRoomButton = new javax.swing.JButton();
        dropRoomButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        roomStatusTable = new javax.swing.JTable();
        datePanel = new javax.swing.JPanel();
        dateCalendar = new com.toedter.calendar.JCalendar();
        addDateButton = new javax.swing.JButton();
        deleteDateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateStatusTable = new javax.swing.JTable();
        reservationPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        seatCapacityTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        reserveDateComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        reserveFacultyComboBox = new javax.swing.JComboBox<>();
        reserveRoomSubmitButton = new javax.swing.JButton();
        resetFilterButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        filterByFacultyComboBox = new javax.swing.JComboBox<>();
        filterResultsByFacultyButton = new javax.swing.JButton();
        wipeAllRecordsButtons = new javax.swing.JButton();
        wipeRecordsPasswordTextField = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        wipeRecordsUsernameTextField = new javax.swing.JTextField();
        filterResultsByDateButton = new javax.swing.JButton();
        filterByDateComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reservationStatusTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        waitlistStatusTable = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        deleteReservationButton = new javax.swing.JButton();
        deleteWaitlistButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout roomModificationDialogLayout = new javax.swing.GroupLayout(roomModificationDialog.getContentPane());
        roomModificationDialog.getContentPane().setLayout(roomModificationDialogLayout);
        roomModificationDialogLayout.setHorizontalGroup(
            roomModificationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        roomModificationDialogLayout.setVerticalGroup(
            roomModificationDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Faculty Name: ");

        addFacultyTextField.setColumns(20);

        addFacultySubmitButton.setText("Add faculty member");
        addFacultySubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFacultySubmitButtonActionPerformed(evt);
            }
        });

        addFacultyStatusLabel.setText(" ");

        fireFacultyStatusLabel.setText(" ");
        fireFacultyStatusLabel.setToolTipText("");

        fireFacultyButton.setText("Fire faculty member");
        fireFacultyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireFacultyButtonActionPerformed(evt);
            }
        });

        facultyStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Faculty Name"
            }
        ));
        jScrollPane2.setViewportView(facultyStatusTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(addFacultyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addFacultySubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFacultyStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fireFacultyStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fireFacultyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(285, 285, 285))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addComponent(addFacultyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(addFacultySubmitButton)
                        .addGap(6, 6, 6)
                        .addComponent(addFacultyStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(fireFacultyButton)
                .addGap(18, 18, 18)
                .addComponent(fireFacultyStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Manage Faculty", jPanel1);

        jLabel8.setText("Room number: ");

        roomNumberTextField.setColumns(5);

        jLabel9.setText("Room capacity: ");

        roomCapacityTextField.setColumns(5);

        addRoomButton.setText("Add Room");
        addRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomButtonActionPerformed(evt);
            }
        });

        dropRoomButton.setText("Drop Room");
        dropRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropRoomButtonActionPerformed(evt);
            }
        });

        roomStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Room", "Number of Seats"
            }
        ));
        jScrollPane5.setViewportView(roomStatusTable);

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(40, 40, 40)
                        .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(roomCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dropRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(484, 484, 484))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roomPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9))
                            .addComponent(roomCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(addRoomButton))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(dropRoomButton))
        );

        jTabbedPane1.addTab("Manage Rooms", roomPanel);

        addDateButton.setText("Add Date");
        addDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDateButtonActionPerformed(evt);
            }
        });

        deleteDateButton.setText("Delete Date");
        deleteDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDateButtonActionPerformed(evt);
            }
        });

        dateStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Date"
            }
        ));
        jScrollPane1.setViewportView(dateStatusTable);

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteDateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(55, 55, 55))
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(dateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDateButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(deleteDateButton)
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Dates", datePanel);

        jLabel3.setText("Seat Capacity:");

        seatCapacityTextField.setColumns(8);
        seatCapacityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatCapacityTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Date:");

        jLabel5.setText("Faculty:");

        reserveRoomSubmitButton.setText("Add Reservation");
        reserveRoomSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveRoomSubmitButtonActionPerformed(evt);
            }
        });

        resetFilterButton.setText("Reset Filters");
        resetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Filter results by faculty:");

        filterResultsByFacultyButton.setText("Filter by Faculty");
        filterResultsByFacultyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterResultsByFacultyButtonActionPerformed(evt);
            }
        });

        wipeAllRecordsButtons.setText("Wipe All Records");
        wipeAllRecordsButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wipeAllRecordsButtonsActionPerformed(evt);
            }
        });

        wipeRecordsPasswordTextField.setColumns(8);

        jLabel15.setText("Password: ");

        jLabel16.setText("Username: ");

        wipeRecordsUsernameTextField.setColumns(8);

        filterResultsByDateButton.setText("Filter By Date");
        filterResultsByDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterResultsByDateButtonActionPerformed(evt);
            }
        });

        jLabel17.setText("Filter results by date: ");

        reservationStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Faculty", "Room Number", "Date", "Number of Seats", "Timestamp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(reservationStatusTable);

        waitlistStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Faculty", "Date", "Number of Seats", "Timestamp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(waitlistStatusTable);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("RESERVATIONS");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setText("WAITLIST");

        deleteReservationButton.setText("Cancel Reservation");
        deleteReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReservationButtonActionPerformed(evt);
            }
        });

        deleteWaitlistButton.setText("Delete Waitlist");
        deleteWaitlistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteWaitlistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reservationPanelLayout = new javax.swing.GroupLayout(reservationPanel);
        reservationPanel.setLayout(reservationPanelLayout);
        reservationPanelLayout.setHorizontalGroup(
            reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationPanelLayout.createSequentialGroup()
                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel19)
                            .addGap(340, 340, 340)))
                    .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reservationPanelLayout.createSequentialGroup()
                            .addGap(345, 345, 345)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(reservationPanelLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(reservationPanelLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(reservationPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(102, 102, 102)
                                            .addComponent(reserveDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(149, 149, 149)
                                            .addComponent(jLabel14)
                                            .addGap(18, 18, 18)
                                            .addComponent(filterByFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(reservationPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(88, 88, 88)
                                            .addComponent(reserveFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(149, 149, 149)
                                            .addComponent(jLabel17)
                                            .addGap(28, 28, 28)
                                            .addComponent(filterByDateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(reservationPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(50, 50, 50)
                                    .addComponent(seatCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(reserveRoomSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(filterResultsByDateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filterResultsByFacultyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(resetFilterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(87, 87, 87)
                            .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(reservationPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(19, 19, 19)
                                        .addComponent(wipeRecordsPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(wipeAllRecordsButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(wipeRecordsUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(reservationPanelLayout.createSequentialGroup()
                            .addGap(657, 657, 657)
                            .addComponent(jLabel18))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPanelLayout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPanelLayout.createSequentialGroup()
                        .addComponent(deleteReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPanelLayout.createSequentialGroup()
                        .addComponent(deleteWaitlistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))))
        );
        reservationPanelLayout.setVerticalGroup(
            reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationPanelLayout.createSequentialGroup()
                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(reserveFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel17))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterByDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterResultsByDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(wipeRecordsUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(reserveDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel14))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(filterByFacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filterResultsByFacultyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel15))
                    .addGroup(reservationPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(wipeRecordsPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resetFilterButton)
                        .addComponent(wipeAllRecordsButtons))
                    .addGroup(reservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reservationPanelLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel3))
                        .addComponent(seatCapacityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(reserveRoomSubmitButton)
                .addGap(8, 8, 8)
                .addComponent(jLabel18)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteReservationButton)
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteWaitlistButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Reservations", reservationPanel);

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Room Scheduler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(492, 492, 492)
                .addComponent(jLabel1)
                .addGap(492, 492, 492))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteWaitlistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteWaitlistButtonActionPerformed
        int selectedRow = waitlistStatusTable.getSelectedRow();

        String selectedFaculty = waitlistStatusTable.getModel().getValueAt(selectedRow, 0).toString();
        java.sql.Date selectedDate = Date.valueOf(waitlistStatusTable.getModel().getValueAt(selectedRow, 1).toString());

        JOptionPane.showMessageDialog(reservationPanel, "Successfully deleted waitlist for " + selectedFaculty + " on " + selectedDate);

        WaitlistQueries.deleteWaitlistEntry(selectedFaculty, selectedDate);
        rebuildWaitlistStatusTable();

    }//GEN-LAST:event_deleteWaitlistButtonActionPerformed

    private void deleteReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReservationButtonActionPerformed
        int selectedRow = reservationStatusTable.getSelectedRow();

        String selectedFaculty = reservationStatusTable.getModel().getValueAt(selectedRow, 0).toString();
        String selectedRoom = reservationStatusTable.getModel().getValueAt(selectedRow, 1).toString();
        
        String addedFaculty = "";
        
        java.sql.Date selectedDate = Date.valueOf(reservationStatusTable.getModel().getValueAt(selectedRow, 2).toString());
        ArrayList<WaitlistEntry> WaitlistByDateList = WaitlistQueries.getWaitlistByDate(selectedDate);
        RoomEntry selectedRoomEntry = RoomQueries.getSelectedRoom(selectedRoom);

        ReservationQueries.deleteReservation(selectedFaculty, selectedRoom, selectedDate);

        for (WaitlistEntry currentEntry : WaitlistByDateList) {

            if (currentEntry.getNumberOfSeats() <= selectedRoomEntry.getNumberOfSeats()) {
                addedFaculty = currentEntry.getFacultyName();
                int numberOfSeats = currentEntry.getNumberOfSeats();
                Timestamp timestampAtWaitlist = currentEntry.getReservationTimestamp();

                ReservationQueries.addReservationEntry(addedFaculty, selectedRoom, selectedDate, numberOfSeats, timestampAtWaitlist);
                WaitlistQueries.deleteWaitlistEntry(addedFaculty, selectedDate);
                break;
            }

        }

        JOptionPane.showMessageDialog(reservationPanel, "Successfully deleted reservation for " + selectedFaculty + " on " + selectedDate + " in " + selectedRoom 
                    + "\n\n New reservation made for " + addedFaculty + " on " + selectedDate + " in "  + selectedRoom);
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
    }//GEN-LAST:event_deleteReservationButtonActionPerformed

    private void filterResultsByDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterResultsByDateButtonActionPerformed
        Date filterDate = Date.valueOf(filterByDateComboBox.getSelectedItem().toString());
        rebuildReservationStatusTable(filterDate);
        rebuildWaitlistStatusTable(filterDate);
    }//GEN-LAST:event_filterResultsByDateButtonActionPerformed

    private void wipeAllRecordsButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wipeAllRecordsButtonsActionPerformed
        String wipeRecordsUsername = wipeRecordsUsernameTextField.getText();
        String wipeRecordsPassword = wipeRecordsPasswordTextField.getText();

        if (("java".equals(wipeRecordsUsername)) && ("java".equals(wipeRecordsPassword))) {
            ReservationQueries.wipeAllRecords();
            WaitlistQueries.wipeAllRecords();

            wipeRecordsUsernameTextField.setText("");
            wipeRecordsPasswordTextField.setText("");

            rebuildReservationStatusTable();
            rebuildWaitlistStatusTable();
        } else {
            JOptionPane.showMessageDialog(reservationPanel, "NOT SO FAST!\nBYE BYE!");
            System.exit(0);
        }
    }//GEN-LAST:event_wipeAllRecordsButtonsActionPerformed

    private void filterResultsByFacultyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterResultsByFacultyButtonActionPerformed
        String filterFaculty = filterByFacultyComboBox.getSelectedItem().toString();
        rebuildReservationStatusTable(filterFaculty);
        rebuildWaitlistStatusTable(filterFaculty);
    }//GEN-LAST:event_filterResultsByFacultyButtonActionPerformed

    private void resetFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButtonActionPerformed
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
    }//GEN-LAST:event_resetFilterButtonActionPerformed

    private void reserveRoomSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveRoomSubmitButtonActionPerformed
        String facultyName = reserveFacultyComboBox.getSelectedItem().toString();
        Date selectedDate = Date.valueOf(reserveDateComboBox.getSelectedItem().toString());
        int numberOfSeats = Integer.parseInt(seatCapacityTextField.getText());
        Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

        ArrayList<ReservationEntry> reservationsByDate = ReservationQueries.getReservationByDate(selectedDate);
        ArrayList<WaitlistEntry> waitlistByDate = WaitlistQueries.getWaitlistByDate(selectedDate);

        ArrayList<String> reservationsByFaculty = new ArrayList<>();
        ArrayList<String> waitlistByFaculty = new ArrayList<>();

        for (ReservationEntry currentEntry : reservationsByDate) {
            reservationsByFaculty.add(currentEntry.getFacultyName());
        }

        for (WaitlistEntry currentEntry : waitlistByDate) {
            waitlistByFaculty.add(currentEntry.getFacultyName());
        }

        seatCapacityTextField.setText("");

        if (reservationsByFaculty.contains(facultyName)) {
            reservationOptionPane.showMessageDialog(reservationPanel, "Faculty member already has a room reserved for " + selectedDate);
            return;
        } else if (waitlistByFaculty.contains(facultyName)) {
            reservationOptionPane.showMessageDialog(reservationPanel, "Faculty member is already on the waitlist for " + selectedDate);
            return;
        }

        ArrayList<String> possibleRooms = RoomQueries.getAllPossibleRooms(numberOfSeats);
        ArrayList<String> reservedRooms = ReservationQueries.getRoomsReservedByDate(selectedDate);

        for (String room : possibleRooms) {
            if (!reservedRooms.contains(room)) {
                ReservationQueries.addReservationEntry(facultyName, room, selectedDate, numberOfSeats, currentTimestamp);
                reservationOptionPane.showMessageDialog(reservationPanel, "Room Successfully Reserved!"
                        + "\n\nFaculty Name:            " + facultyName
                        + "\nRoom Number:         " + room
                        + "\nReservation Date:     " + selectedDate
                        + "\nNumber of seats:      " + numberOfSeats);

                rebuildReservationStatusTable();
                return;
            }
        }

        WaitlistQueries.addWaitlistEntry(facultyName, selectedDate, numberOfSeats, currentTimestamp);
        reservationOptionPane.showMessageDialog(reservationPanel, "Room Unsuccessfully Reserved!"
                + "\nYour request has been placed on the waitlist!"
                + "\n\nFaculty name:              " + facultyName
                + "\nReservation date:       " + selectedDate
                + "\nNumber of seats:       " + numberOfSeats);
        rebuildWaitlistStatusTable();
    }//GEN-LAST:event_reserveRoomSubmitButtonActionPerformed

    private void seatCapacityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatCapacityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatCapacityTextFieldActionPerformed

    private void deleteDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDateButtonActionPerformed
        int selectedRow = dateStatusTable.getSelectedRow();
        java.sql.Date selectedDate = Date.valueOf(dateStatusTable.getModel().getValueAt(selectedRow, 0).toString());

        Dates.deleteDate(selectedDate);
        WaitlistQueries.deleteWaitlistEntryByDate(selectedDate);
        ReservationQueries.deleteReservationByDate(selectedDate);
        
        dateModificationOptionPane.showMessageDialog(datePanel, selectedDate + " has been successfully removed");
        
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
        rebuildDatesStatusTable();
        rebuildDateComboBoxes();
    }//GEN-LAST:event_deleteDateButtonActionPerformed

    private void addDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDateButtonActionPerformed
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDate = formater.format(dateCalendar.getDate());
        Date sqlSelectedDate = Date.valueOf(selectedDate);

        ArrayList<Date> allDates = Dates.getDatesList();

        if (allDates.contains(sqlSelectedDate)) {
            dateModificationOptionPane.showMessageDialog(datePanel, sqlSelectedDate + " is already in the DATES table");
        } else {
            Dates.addDate(sqlSelectedDate);
            rebuildDatesStatusTable();
            rebuildDateComboBoxes();
        }
    }//GEN-LAST:event_addDateButtonActionPerformed

    private void dropRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropRoomButtonActionPerformed
        int selectedRow = roomStatusTable.getSelectedRow();
        String roomNumber = roomStatusTable.getModel().getValueAt(selectedRow, 0).toString();
        RoomQueries.dropRoom(roomNumber);

        ArrayList<ReservationEntry> reservationList = ReservationQueries.getReservationByRoom(roomNumber);
        for (ReservationEntry currentEntry : reservationList) {
            WaitlistQueries.addWaitlistEntry(currentEntry);
            ReservationQueries.deleteReservation(currentEntry);
        }

        roomModificationOptionPane.showMessageDialog(roomPanel, "Room successfully removed!"
                + "\n\nRoom number: " + roomNumber);

        addReservationsFromWaitlist();
        rebuildRoomsStatusTable();
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
    }//GEN-LAST:event_dropRoomButtonActionPerformed

    private void addRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomButtonActionPerformed

        String roomNumber = roomNumberTextField.getText();
        int roomCapacity = Integer.parseInt(roomCapacityTextField.getText());
        roomNumberTextField.setText("");
        roomCapacityTextField.setText("");

        RoomQueries.addRoom(roomNumber, roomCapacity);

        addReservationsFromWaitlist();
        rebuildWaitlistStatusTable();
        rebuildReservationStatusTable();
        rebuildRoomsStatusTable();

        roomModificationOptionPane.showMessageDialog(roomPanel, "Room successfully added!"
                + "\n\nRoom number:             " + roomNumber
                + "\nNumber of seats:         " + roomCapacity);

    }//GEN-LAST:event_addRoomButtonActionPerformed

    private void fireFacultyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireFacultyButtonActionPerformed
        int selectedRow = facultyStatusTable.getSelectedRow();
        String facultyName = facultyStatusTable.getModel().getValueAt(selectedRow, 0).toString();
        Faculty.fireFaculty(facultyName);
        fireFacultyStatusLabel.setText("You just fired: " + facultyName);

        ReservationQueries.deleteReservationByFaculty(facultyName);
        WaitlistQueries.deleteWaitlistEntryByFaculty(facultyName);

        addReservationsFromWaitlist();
        rebuildFacultyComboBoxes();
        rebuildReservationStatusTable();
        rebuildWaitlistStatusTable();
        rebuildFacultyStatusTable();
    }//GEN-LAST:event_fireFacultyButtonActionPerformed

    private void addFacultySubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFacultySubmitButtonActionPerformed
        String name = addFacultyTextField.getText();
        Faculty.addFaculty(name);

        addFacultyStatusLabel.setText(name + " has been added to the faculty list.");

        addFacultyTextField.setText("");
        rebuildFacultyComboBoxes();
        rebuildFacultyStatusTable();
    }//GEN-LAST:event_addFacultySubmitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDateButton;
    private javax.swing.JLabel addFacultyStatusLabel;
    private javax.swing.JButton addFacultySubmitButton;
    private javax.swing.JTextField addFacultyTextField;
    private javax.swing.JButton addRoomButton;
    private com.toedter.calendar.JCalendar dateCalendar;
    private javax.swing.JPanel datePanel;
    private javax.swing.JTable dateStatusTable;
    private javax.swing.JButton deleteDateButton;
    private javax.swing.JButton deleteReservationButton;
    private javax.swing.JButton deleteWaitlistButton;
    private javax.swing.JButton dropRoomButton;
    private javax.swing.JTable facultyStatusTable;
    private javax.swing.JComboBox<String> filterByDateComboBox;
    private javax.swing.JComboBox<String> filterByFacultyComboBox;
    private javax.swing.JButton filterResultsByDateButton;
    private javax.swing.JButton filterResultsByFacultyButton;
    private javax.swing.JButton fireFacultyButton;
    private javax.swing.JLabel fireFacultyStatusLabel;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel reservationPanel;
    private javax.swing.JTable reservationStatusTable;
    private javax.swing.JComboBox<String> reserveDateComboBox;
    private javax.swing.JComboBox<String> reserveFacultyComboBox;
    private javax.swing.JButton reserveRoomSubmitButton;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JTextField roomCapacityTextField;
    private javax.swing.JDialog roomModificationDialog;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JTable roomStatusTable;
    private javax.swing.JTextField seatCapacityTextField;
    private javax.swing.JTable waitlistStatusTable;
    private javax.swing.JButton wipeAllRecordsButtons;
    private javax.swing.JTextField wipeRecordsPasswordTextField;
    private javax.swing.JTextField wipeRecordsUsernameTextField;
    // End of variables declaration//GEN-END:variables
}
