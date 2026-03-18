public class BikeRental {

    /**
     * Tinh phi thue xe dap cong cong theo co che bac thang luy tien.
     *
     * Cong thuc:
     *   - 0 < soGio < 4  : phi = giaCoBan * soGio * heSoThe
     *   - 4 <= soGio < 8 : phi = (giaCoBan*4 + (soGio-4)*giaCoBan*0.9) * heSoThe
     *   - 8 <= soGio <=24: phi = (giaCoBan*4*1.9 + (soGio-8)*giaCoBan*0.8) * heSoThe
     *
     * Trong do:
     *   giaCoBan : 5000 (ngay thuong) | 7000 (cuoi tuan)
     *   heSoThe  : 1.0  (the thuong)  | 0.8  (the sinh vien)
     *
     * Tra ve -1 neu dau vao khong hop le:
     *   - loaiThe  khong thuoc {"thuong", "sinhvien"} hoac null
     *   - loaiNgay khong thuoc {"thuong", "cuoituan"} hoac null
     *   - soGio <= 0 hoac soGio > 24
     *
     * @param loaiThe  "thuong" | "sinhvien"
     * @param soGio    so gio thue (double), hop le trong (0, 24]
     * @param loaiNgay "thuong" | "cuoituan"
     * @return phi thue (dong) hoac -1 neu dau vao khong hop le
     */
    public static double tinhPhi(String loaiThe, double soGio, String loaiNgay) {

        if(!loaiThe.equals("sinhvien"))
        {
            loaiThe = "thuong";
        }

        if (soGio < 0 || soGio > 24) {
            return -1;
        }

        double giaCoBan = loaiNgay.equals("cuoituan") ? 7000 : 5000;
        double heSoThe = loaiThe.equals("sinhvien") ? 0.8 : 1.0;

        double phi;

        if (soGio < 4) {
            // Bac 1: toan bo gio thue tinh gia goc
            phi = giaCoBan * soGio;

        } else if (soGio < 8) {
            // Bac 2: 4 gio dau gia goc + phan con lai giam 10%
            phi = giaCoBan * 4
                    + (soGio - 4) * giaCoBan * 0.9;

        } else {
            // Bac 3: phi cong don bac 1+2 + phan con lai giam 20%
            // giaCoBan*4*1.9 = giaCoBan*4*(1.0+0.9)
            phi = giaCoBan * 4 * 1.9
                    + (soGio - 8) * giaCoBan * 0.8;
        }

        return phi * heSoThe;
    }
}