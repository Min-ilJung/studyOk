import java.io.*;
import java.sql.*;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.lang.StringEscapeUtils;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "alslfl0";
        Connection conn = null;

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        try {
           conn = DriverManager.getConnection(url, username, password);
           System.out.println("Database connection successful");

            FileInputStream file = new FileInputStream(new File("D:\\workspaceIj\\testPrj\\ebc-anyman_data_12_01_22_to_1_31_23.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);

System.out.println("첫번째 씨트 등록 시작...");            
            Sheet sheet = workbook.getSheetAt(0);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO sheet1 (va,vb,vc,vd,ve) VALUES");

            Iterator<Row> iterator = sheet.iterator();
            int st = 0;
            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0) sb.append(String.format("('%s','%s','%s','%s','%s'),", va, vb, vc, vd, ve));
                st++;
            }
            String sql = sb.toString().substring(0, sb.length() - 1);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
System.out.println("첫번째 씨트 등록 완료. " + (st-1) + "건 ");

System.out.println("첫번째 씨트 검수 시작. ");
            String query = "SELECT count(*) cnt FROM sheet1 WHERE va is null or va = ''";
            // 쿼리 실행
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int cnt = 0;
            while (rs.next())  cnt = rs.getInt("cnt");
            stmt.close();
System.out.println("첫번째 씨트 검수 완료. 오류건 : " + cnt + "건 ");


System.out.println("두번째 씨트 등록 시작...");
            sheet = workbook.getSheetAt(1);
            sb = new StringBuilder();
            sb.append("INSERT INTO sheet2 (va,vb,vc,vd,ve,vf,vg,vh,vi,vj,vk) VALUES");
            iterator = sheet.iterator();
            st = 0;
            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));
                String vf = formatter.formatCellValue(row.getCell(5));
                String vg = formatter.formatCellValue(row.getCell(6));
                String vh = formatter.formatCellValue(row.getCell(7));
                String vi = formatter.formatCellValue(row.getCell(8));
                String vj = formatter.formatCellValue(row.getCell(9));
                String vk = formatter.formatCellValue(row.getCell(10));

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0 ) sb.append(String.format("('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'),", va, vb, vc, vd, ve, vf, vg, vh, vi, vj, vk));
                st++;
            }
            sql = sb.toString().substring(0, sb.length() - 1);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
System.out.println("두번째 씨트 등록 완료. " + (st-1) + "건 ");

System.out.println("두번째 씨트 검수 시작. ");
            query = "SELECT count(*) cnt FROM sheet2 WHERE va is null or va = ''";
            // 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            cnt = 0;
            while (rs.next())  cnt = rs.getInt("cnt");
            stmt.close();
System.out.println("두번째 씨트 검수 완료. 오류건 : " + cnt + "건 ");


System.out.println("세번째 씨트 등록 시작...");
            sheet = workbook.getSheetAt(2);
            sb = new StringBuilder();
            sb.append("INSERT INTO sheet3 (va,vb,vc,vd,ve,vf,vg) VALUES");
            iterator = sheet.iterator();
            st = 0;
            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));
                String vf = formatter.formatCellValue(row.getCell(5));
                String vg = formatter.formatCellValue(row.getCell(6));

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0 ) sb.append(String.format("('%s','%s','%s','%s','%s','%s','%s'),", va, vb, vc, vd, ve, vf, vg));
                st++;
            }
            sql = sb.toString().substring(0, sb.length() - 1);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

System.out.println("세번째 씨트 등록 완료. " + (st-1) + "건 ");

System.out.println("세번째 씨트 검수 시작. ");
            query = "SELECT count(*) cnt FROM sheet3 WHERE va is null or va = ''";
            // 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            cnt = 0;
            while (rs.next())  cnt = rs.getInt("cnt");
            stmt.close();
System.out.println("세번째 씨트 검수 완료. 오류건 : " + cnt + "건 ");

System.out.println("네번째 씨트 등록 시작...");
            sheet = workbook.getSheetAt(3);
            sb = new StringBuilder();
            sb.append("INSERT INTO sheet4 (va,vb,vc,vd,ve,vf,vg,vh,vi,vj,vk,vl,vm,vn,vo,vp) VALUES");
            iterator = sheet.iterator();
            st = 0;
            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));
                String vf = formatter.formatCellValue(row.getCell(5));
                String vg = formatter.formatCellValue(row.getCell(6));
                String vh = formatter.formatCellValue(row.getCell(7));
                vh = vh.replaceAll("'","\\'").replace("\"", "\\\"");
                vh = StringEscapeUtils.escapeSql(vh);
                //vh = "";
                String vi = formatter.formatCellValue(row.getCell(8));
                String vj = formatter.formatCellValue(row.getCell(9));
                String vk = formatter.formatCellValue(row.getCell(10));
                String vl = formatter.formatCellValue(row.getCell(11));
                String vm = formatter.formatCellValue(row.getCell(12));
                String vn = formatter.formatCellValue(row.getCell(13));
                String vo = formatter.formatCellValue(row.getCell(14));
                String vp = formatter.formatCellValue(row.getCell(15));

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0 ) sb.append(String.format("('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'),", va,vb,vc,vd,ve,vf,vg,vh,vi,vj,vk,vl,vm,vn,vo,vp));
                st++;
            }
            sql = sb.toString().substring(0, sb.length() - 1);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
System.out.println("네번째 씨트 등록 완료. " + (st-1) + "건 ");

 System.out.println("네번째 씨트 검수 시작. ");
            query = "SELECT COUNT(IF(vb = '' OR vb is null, 1, NULL)) AS vb_cnt\n" +
                    "     , COUNT(IF(vm = '' OR vm is null, 1, NULL)) AS vm_cnt\n" +
                    "FROM sheet4;";
            // 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            cnt = 0;
            int cnt1 = 0;
            while (rs.next()){
                cnt = rs.getInt("vb_cnt");
                cnt1 = rs.getInt("vm_cnt");
            }
            stmt.close();
System.out.println("네번째 씨트 검수 완료. vb 오류건 : " + cnt + "건 ");
System.out.println("네번째 씨트 검수 완료. vm 오류건 : " + cnt1 + "건 ");

System.out.println("다섯번째 씨트 등록 시작...");
            sheet = workbook.getSheetAt(4);
            sb = new StringBuilder();
            sb.append("INSERT INTO sheet5 (va,vb,vc,vd,ve,vf,vg,vh,vi) VALUES");
            iterator = sheet.iterator();
            st = 0;
            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));
                String vf = formatter.formatCellValue(row.getCell(5));
                String vg = formatter.formatCellValue(row.getCell(6));

                String vh = formatter.formatCellValue(row.getCell(7));
                String vi = formatter.formatCellValue(row.getCell(8));

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0 ) sb.append(String.format("('%s','%s','%s','%s','%s','%s','%s','%s','%s'),", va,vb,vc,vd,ve,vf,vg,vh,vi));
                st++;
            }
            sql = sb.toString().substring(0, sb.length() - 1);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
System.out.println("다섯번째 씨트 등록 완료. " + (st-1) + "건 ");

System.out.println("다섯번째 씨트 검수 시작. ");
            query = "SELECT count(*) cnt FROM sheet4 WHERE va is null or va = ''";
            // 쿼리 실행
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            cnt = 0;
            while (rs.next())  cnt = rs.getInt("cnt");
            stmt.close();
System.out.println("다섯번째 씨트 검수 완료. 오류건 : " + cnt + "건 ");

/*

            System.out.println("네번째 씨트 등록 시작...");
            sheet = workbook.getSheetAt(3);

            sql = "INSERT INTO sheet4 (va,vb,vc,vd,ve,vf,vg,vh,vi,vj,vk,vl,vm,vn,vo,vp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            iterator = sheet.iterator();
            st = 0;
            int batchSize = 100; // 일괄 삽입할 데이터 개수
            int count = 0;
            int[] result = null;

            while (iterator.hasNext()) {
                DataFormatter formatter = new DataFormatter();
                Row row = iterator.next();
                String va = formatter.formatCellValue(row.getCell(0));
                String vb = formatter.formatCellValue(row.getCell(1));
                String vc = formatter.formatCellValue(row.getCell(2));
                String vd = formatter.formatCellValue(row.getCell(3));
                String ve = formatter.formatCellValue(row.getCell(4));
                String vf = formatter.formatCellValue(row.getCell(5));
                String vg = formatter.formatCellValue(row.getCell(6));
                String vh = formatter.formatCellValue(row.getCell(7));
                vh = removeEmojis(vh);
                vh = "";
                String vi = formatter.formatCellValue(row.getCell(8));
                String vj = formatter.formatCellValue(row.getCell(9));
                String vk = formatter.formatCellValue(row.getCell(10));
                String vl = formatter.formatCellValue(row.getCell(11));
                String vm = formatter.formatCellValue(row.getCell(12));
                String vn = formatter.formatCellValue(row.getCell(13));
                String vo = formatter.formatCellValue(row.getCell(14));
                String vp = formatter.formatCellValue(row.getCell(15));

                pstmt.setString(1, va);
                pstmt.setString(2, vb);
                pstmt.setString(3, vc);
                pstmt.setString(4, vd);
                pstmt.setString(5, ve);
                pstmt.setString(6, vf);
                pstmt.setString(7, vg);
                pstmt.setString(8, vh);
                pstmt.setString(9, vi);
                pstmt.setString(10, vj);
                pstmt.setString(11, vk);
                pstmt.setString(12, vl);
                pstmt.setString(13, vm);
                pstmt.setString(14, vn);
                pstmt.setString(15, vo);
                pstmt.setString(16, vp);

                if(va=="" && vb=="" && vc=="" && vd=="") break;
                if(st>0 ) pstmt.addBatch();
                if(st > 997 && 1000 > st) System.out.println(st + " : "+ vh);

                if (++count % batchSize == 0) {
                    pstmt.executeBatch(); // 일괄 삽입 실행
                    System.out.println(count + "등록 처리 ...");
                }
                st++;
            }
            pstmt.executeBatch(); // 일괄 삽입 실행
            System.out.println("네번째 씨트 등록 완료. " + (st-1) + "건 ");
            pstmt.close();
*/



           /*
           String sql = "INSERT INTO sheet1 (va,vb,vc,vd,ve) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement pstmt = conn.prepareStatement(sql);

            try {
                FileInputStream file = new FileInputStream(new File("D:\\workspaceIj\\testPrj\\ebc-anyman_data_12_01_22_to_1_31_23.xlsx"));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                Sheet sheet = workbook.getSheetAt(0);

                HashMap<String,String> mydata;

                ArrayList dataList = new ArrayList<>();
                DataFormatter formatter = new DataFormatter();
                int st = 0;
                for (Row row : sheet) {
                    mydata = new HashMap<>();
                    mydata.put("va",formatter.formatCellValue(row.getCell(0)));
                    mydata.put("vb",formatter.formatCellValue(row.getCell(1)));
                    mydata.put("vc",formatter.formatCellValue(row.getCell(2)));
                    mydata.put("vd",formatter.formatCellValue(row.getCell(3)));
                    mydata.put("ve",formatter.formatCellValue(row.getCell(4)));
                    if(st>0)dataList.add(mydata);
                    st++;
                }
                System.out.println("등록프로세스 시작...");

                int batchSize = 1000; // 일괄 삽입할 데이터 개수
                int count = 0;
                int[] result = null;
                for (int i=0; i < dataList.size(); i++) {
                    mydata = new HashMap<>();
                    mydata = (HashMap<String, String>)dataList.get(i);
                    pstmt.setString(1, mydata.get("va"));
                    pstmt.setString(2, mydata.get("vb"));
                    pstmt.setString(3, mydata.get("vc"));
                    pstmt.setString(4, mydata.get("vd"));
                    pstmt.setString(5, mydata.get("ve"));
                    pstmt.addBatch();

                    if (++count % batchSize == 0) {
                        result = pstmt.executeBatch(); // 일괄 삽입 실행
                        System.out.println(count + "등록 처리 ...");
                    }
                }
                result = pstmt.executeBatch();
                System.out.println("등록 완료 !!!! ");
                System.out.println(result.length);


                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Database close successful");
            conn.close();
            long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
            long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
            System.out.println("수행시간 : "+secDiffTime);
        }
    }

    public static String removeEmojis(String text) {
        return text.replaceAll("[\\p{InEmoticons}]", "");
    }
}