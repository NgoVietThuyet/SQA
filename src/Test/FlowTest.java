package Test;

import code.BikeRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FlowTest {

    @Nested
    @DisplayName("Phan 3: Kiem thu C2")
    class C2Testing {
        @Test @DisplayName("1 | loaiNgay=cuoituan loaiThe=sinhvien soGio=-1   -> -1")
        void C2_01() { Assertions.assertEquals(-1,  BikeRental.tinhPhi("sinhvien", -1, "cuoituan")); }
        @Test @DisplayName("2 | loaiNgay=cuoituan loaiThe=sinhvien soGio=2   -> 11200")
        void C2_02() { Assertions.assertEquals(11200,  BikeRental.tinhPhi("sinhvien", 2, "cuoituan")); }
        @Test @DisplayName("3 | loaiNgay=thuong loaiThe=thuong soGio=7   -> 33500")
        void C2_03() { Assertions.assertEquals(33500,  BikeRental.tinhPhi("thuong", 7, "thuong")); }
        @Test @DisplayName("4 | loaiNgay=thuong loaiThe=thuong soGio=15   -> 66000")
        void C2_04() { Assertions.assertEquals(66000,  BikeRental.tinhPhi("thuong", 15, "thuong")); }
    }
}




