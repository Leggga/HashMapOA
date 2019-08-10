import org.junit.Assert;
import org.junit.Test;
import task.HashMapOA;

public class HashMapOATest {

    public static final int[] keys = {7, 12356, 2424, 66, 11, 156, 1024};
    public static final long[] values = {-56533221L, 254223L, -353514L, -3212L, 101L, 639L, 4222L};

    @Test
    public void mapShouldBeEmpty() {
        HashMapOA map = new HashMapOA();
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void mapSizeShouldBeEqualKeyArrayLength() {
        HashMapOA map = new HashMapOA();

        for(int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        Assert.assertEquals(keys.length, map.size());
    }

    @Test
    public void putShouldRefreshValuesOfKeys() {
        HashMapOA map = new HashMapOA();

        for(int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        map.put(7, 153);
        map.put(66, 2048);

        Assert.assertEquals(keys.length, map.size());
    }

    @Test
    public void getShouldReturnRightValues() {
        HashMapOA map = new HashMapOA();

        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        for (int i = 0; i < keys.length; i++) {
            Assert.assertEquals(map.get(keys[i]), values[i]);
        }
    }

    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void keysShouldBePositive() {
        HashMapOA map = new HashMapOA();
        map.put(-1, 1021);
    }

    @Test
    public void mapShouldBeIncreased() {
        HashMapOA map = new HashMapOA(5);

        for(int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        Assert.assertEquals(keys.length, map.size());
    }

    @Test
    public void getNonExistKey() {
        HashMapOA map = new HashMapOA();

        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        Assert.assertEquals(-1, map.get(77));
    }
}
