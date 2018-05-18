package com.konovalov;

import java.sql.*;

public class DbFlat {
    private Connection connect = null;
    private DbProperties properties = new DbProperties();

    public DbFlat() {
        try {
            connect = DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());
            System.out.println("Connect YES to " + properties.getUrl());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try (Statement st = connect.createStatement()) {
            st.execute("CREATE TABLE `flat` (\n" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `city` varchar(24) NOT NULL,\n" +
                    "  `adress` varchar(64) NOT NULL,\n" +
                    "  `area` float NOT NULL,\n" +
                    "  `room` int(11) NOT NULL,\n" +
                    "  `price` int(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE KEY `flat_id_uindex` (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8\n" +
                    "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        try (Statement st = connect.createStatement()) {
            st.execute("DROP TABLE flat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Flat flat) {
        try (PreparedStatement ps = connect.prepareStatement("INSERT INTO flat(city, adress, area, room, price) VALUES (?,?,?,?,?)")) {
            ps.setString(1, flat.getCity());
            ps.setString(2, flat.getAdress());
            ps.setFloat(3, (float) flat.getArea());
            ps.setInt(4, flat.getRoom());
            ps.setInt(5, flat.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCityFilter(String condition) {
        String query = "SELECT * FROM flat WHERE " + condition;

        try (Statement st = connect.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Flat flat = new Flat();
                flat.setId(rs.getInt("id"));
                flat.setCity(rs.getString("city"));
                flat.setAdress(rs.getString("adress"));
                flat.setArea(rs.getFloat("area"));
                flat.setRoom(rs.getInt("room"));
                flat.setPrice(rs.getInt("price"));
                System.out.println(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
