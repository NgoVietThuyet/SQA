package Test;

import code.BikeRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DataFlowTest {

    @Nested
    @DisplayName("Phan 4: Kiem thu All-Uses")
    class AllUsesTesting {

        @Test
        @DisplayName("TC1 | loaiThe=sinhvien soGio=-1 loaiNgay=ngaythuong -> -1.0")
        void AllUses_01() {
            Assertions.assertEquals(-1.0, BikeRental.tinhPhi("sinhvien", -1, "ngaythuong"));
        }

        @Test
        @DisplayName("TC2 | loaiThe=sinhvien soGio=2 loaiNgay=cuoituan -> 11200.0")
        void AllUses_02() {
            Assertions.assertEquals(11200.0, BikeRental.tinhPhi("sinhvien", 2, "cuoituan"));
        }

        @Test
        @DisplayName("TC3 | loaiThe=khac soGio=3 loaiNgay=ngaythuong -> 15000.0")
        void AllUses_03() {
            Assertions.assertEquals(15000.0, BikeRental.tinhPhi("khac", 3, "ngaythuong"));
        }

        @Test
        @DisplayName("TC4 | loaiThe=khac soGio=6 loaiNgay=cuoituan -> 40600.0")
        void AllUses_04() {
            Assertions.assertEquals(40600.0, BikeRental.tinhPhi("khac", 6, "cuoituan"));
        }

        @Test
        @DisplayName("TC5 | loaiThe=sinhvien soGio=5 loaiNgay=ngaythuong -> 19600.0")
        void AllUses_05() {
            Assertions.assertEquals(19600.0, BikeRental.tinhPhi("sinhvien", 5, "ngaythuong"));
        }

        @Test
        @DisplayName("TC6 | loaiThe=khac soGio=10 loaiNgay=ngaythuong -> 46000.0")
        void AllUses_06() {
            Assertions.assertEquals(46000.0, BikeRental.tinhPhi("khac", 10, "ngaythuong"));
        }
    }
}