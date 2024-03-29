package pl.put.poznan.sorting.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import pl.put.poznan.sorting.logic.BubbleSort;
import pl.put.poznan.sorting.logic.HeapSort;
import pl.put.poznan.sorting.logic.InsertionSort;
import pl.put.poznan.sorting.logic.MergeSort;
import pl.put.poznan.sorting.logic.QuickSort;
import pl.put.poznan.sorting.logic.SelectionSort;
import pl.put.poznan.sorting.logic.SortContext;
import pl.put.poznan.sorting.logic.SortStrategy;
import pl.put.poznan.sorting.logic.SortingWrapper;

@SpringBootTest
class TestSortingMadness {

	@Test
	@DisplayName("Quick testing all sort methods without sorting wrapper")
	void TestSortMethods() 
	{
		SortingWrapper wrapper = mock(SortingWrapper.class);
		when(wrapper.getSorter("quick")).thenReturn(new QuickSort());
		when(wrapper.getSorter("merge")).thenReturn(new MergeSort());
		when(wrapper.getSorter("selection")).thenReturn(new SelectionSort());
		when(wrapper.getSorter("insertion")).thenReturn(new InsertionSort());
		when(wrapper.getSorter("heap")).thenReturn(new HeapSort());
		when(wrapper.getSorter("bubble")).thenReturn(new BubbleSort());
		
		SortContext context;
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {1, 2, 2, 3, 4, 5, 5};
		String[] sortingMethods = {"bubble", "heap", "insertion", "selection", "merge", "quick"};

		for(String method : sortingMethods)
		{
			context = new SortContext(wrapper.getSorter(method));
			Assertions.assertArrayEquals(expected, context.sort(unsorted, null, 0, false));
		}
		verify(wrapper, times(6)).getSorter(anyString());
	}
	
	@Test
	@DisplayName("Quick testing all sort methods without sorting wrapper and reverse sorting")
	void TestSortMethodsReverse() 
	{
		SortingWrapper wrapper = mock(SortingWrapper.class);
		when(wrapper.getSorter("quick")).thenReturn(new QuickSort());
		when(wrapper.getSorter("merge")).thenReturn(new MergeSort());
		when(wrapper.getSorter("selection")).thenReturn(new SelectionSort());
		when(wrapper.getSorter("insertion")).thenReturn(new InsertionSort());
		when(wrapper.getSorter("heap")).thenReturn(new HeapSort());
		when(wrapper.getSorter("bubble")).thenReturn(new BubbleSort());
		
		SortContext context;
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {5, 5, 4, 3, 2, 2, 1};
		String[] sortingMethods = {"bubble", "heap", "insertion", "selection", "merge", "quick"};

		for(String method : sortingMethods)
		{
			context = new SortContext(wrapper.getSorter(method));
			Assertions.assertArrayEquals(expected, context.sort(unsorted, null, 0, true));
		}
		verify(wrapper, times(6)).getSorter(anyString());
	}

	@Test
	@DisplayName("Quick testing all sort methods without sorting wrapper and iteration counting")
	void TestSortMethodsIterations() 
	{
		SortingWrapper wrapper = mock(SortingWrapper.class);
		when(wrapper.getSorter("quick")).thenReturn(new QuickSort());
		when(wrapper.getSorter("merge")).thenReturn(new MergeSort());
		when(wrapper.getSorter("selection")).thenReturn(new SelectionSort());
		when(wrapper.getSorter("insertion")).thenReturn(new InsertionSort());
		when(wrapper.getSorter("heap")).thenReturn(new HeapSort());
		when(wrapper.getSorter("bubble")).thenReturn(new BubbleSort());
		
		SortContext context;
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {1, 2, 2, 3, 4, 5, 5};
		String[] sortingMethods = {"bubble", "heap", "insertion", "selection", "merge", "quick"};

		for(String method : sortingMethods)
		{
			context = new SortContext(wrapper.getSorter(method));
			Assertions.assertFalse(Arrays.equals(context.sort(unsorted, null, 2, false), expected));
		}
		verify(wrapper, times(6)).getSorter(anyString());
	}

	@Test
	@DisplayName("TestSortContext with predefined strategy")
	void TestSortContext()
	{
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {1, 2, 2, 3, 4, 5, 5};
		SortStrategy strategy = mock(BubbleSort.class);
		when(strategy.sort(any(),anyString(),anyInt(),anyBoolean())).thenReturn(expected);

		SortContext context = new SortContext(strategy);
		Assertions.assertArrayEquals(context.sort(unsorted, "somekey", 0, false), expected);

		verify(strategy, times(1)).sort(any(),anyString(),anyInt(),anyBoolean());
	}

	@Test
	@DisplayName("TestSortContext with predefined strategy and reverse sorting")
	void TestSortContextReverse()
	{
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {5, 5, 4, 3, 2, 2, 1};
		SortStrategy strategy = mock(InsertionSort.class);
		when(strategy.sort(any(), anyString(), anyInt(), eq(true))).thenReturn(expected);

		SortContext context = new SortContext(strategy);
		Assertions.assertArrayEquals(context.sort(unsorted, "somekey", 0, true), expected);

		verify(strategy, times(1)).sort(any(), anyString(), anyInt(), eq(true));
	}
	
	@Test
	@DisplayName("TestSortContext with predefined strategy and iteration passing")
	void TestSortContextIterations()
	{
		Integer[] unsorted = {3, 2, 5, 1, 4, 2, 5};
		Integer[] expected = {1, 2, 2, 3, 4, 5, 5};
		SortStrategy strategy = mock(InsertionSort.class);
		when(strategy.sort(any(), anyString(), eq(2), anyBoolean())).thenReturn(unsorted);

		SortContext context = new SortContext(strategy);
		Assertions.assertFalse(Arrays.equals(context.sort(unsorted, "somekey", 2, true), expected));

		verify(strategy, times(1)).sort(any(), anyString(), eq(2), anyBoolean());
	}


	@Test
	@DisplayName("Verfy if sort return thier name")
	void TestNameVerify()
	{
		SortingWrapper wrapper = mock(SortingWrapper.class);
		when(wrapper.getSorter("quick")).thenReturn(new QuickSort());
		when(wrapper.getSorter("merge")).thenReturn(new MergeSort());
		when(wrapper.getSorter("selection")).thenReturn(new SelectionSort());
		when(wrapper.getSorter("insertion")).thenReturn(new InsertionSort());
		when(wrapper.getSorter("heap")).thenReturn(new HeapSort());
		when(wrapper.getSorter("bubble")).thenReturn(new BubbleSort());

		String[] sortingMethods = {"bubble", "heap", "insertion", "selection", "merge", "quick"};
		String[] expectedNames = {"BubbleSort", "HeapSort", "InsertionSort", "SelectionSort", "MergeSort", "QuickSort"};
		
		for(Integer i=0; i < sortingMethods.length;i++)
		{
			Assertions.assertEquals(wrapper.getSorter(sortingMethods[i]).getName(), expectedNames[i]);
		}

	}
}
