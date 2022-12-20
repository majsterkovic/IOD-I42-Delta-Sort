package pl.put.poznan.sorting.logic;

public class AutoSortSelect {
    
    public static Integer inputSize = 8;
    public static Integer RAMLimniter = 4;

    public static String GetSortingAlgorithm(Object[] data, String sortKey)
    {
        Comparator comp = new Comparator(sortKey);
        Integer RiseLenght = 1;
        Integer ArraySize;
        Boolean RAMCapacity = true;

        for(int i = 1; i < data.length; i++)
        {
            if (comp.compareTo(data[i-1], data[i]) >= 0) { RiseLenght++; }
        }
        ArraySize = data.length;
        if(ArraySize * inputSize > Runtime.getRuntime().freeMemory() / RAMLimniter) RAMCapacity = false;

       if (!RAMCapacity) return "heap";
       if (RiseLenght >= ArraySize * 0.975) return "insertion";
       if (RiseLenght >= ArraySize * 0.7) return "merge";
       return "quick";
    }
    
}
