package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.ExpectationError;
import org.junit.Test;
import org.jfree.data.KeyedValues;

public class DataUtilitiesTest extends DataUtilities {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }
	
	// Testing invalid parameter with data as null
	
	@Test (expected = InvalidParameterException.class)
	 public void testCalculateRowTotalNullData() throws InvalidParameterException {
	     
		DataUtilities.calculateRowTotal(null, 0);
	 }
	
	// Testing valid row index and data parameter which contains positive values
	@Test
	 public void testCalculateRowTotalPositiveValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));	            
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after 4.0 + 4.0", 8.0, calculationResult, .000000001d);
	 }
	
	// Testing valid row index and data parameter which contains null values
		@Test
		 public void testCalculateRowTotalNullValues() {
			
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getRowCount();
		            will(returnValue(1));
		            one(values).getValue(0, 0);
		            will(returnValue(null));
		            one(values).getValue(0, 1);
		            will(returnValue(null));	            
		        }
		    });

		     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
		     assertEquals("Row 0 total after null + null", 0, calculationResult, .000000001d);
		 }
	
	// Testing valid row index and data parameter which contains negative values
	@Test
	 public void testCalculateRowTotalNegativeValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(-2.0));
	            one(values).getValue(0, 1);
	            will(returnValue(-12.0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after -2.0 + -12.0", -14.0, calculationResult, .000000001d);
	 }
	
	// Testing valid row index and data parameter which contains positive and negative values
	@Test
	 public void testCalculateRowTotalPositiveNegativeValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(2.0));
	            one(values).getValue(0, 1);
	            will(returnValue(-12.0));
	            one(values).getValue(0, 2);
	            will(returnValue(-11.0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after 2.0 + -12.0 + -11.0", -21.0, calculationResult, .000000001d);
	 }
	
	// Testing valid row index and data parameter with empty row
	@Test
	 public void testCalculateRowTotalEmptyRow() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(0));
	            one(values).getRowCount();
	            will(returnValue(0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Calculate total of empty row", 0, calculationResult, .000000001d);
	 }
	
	// Testing invalid negative row index
	@Test 
	 public void testCalculateRowTotalNegativeRowIndex() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));

	        }
	    });
	     
		double calculationResult = DataUtilities.calculateRowTotal(values, -1);
	    assertEquals("Calculate total with negative row index should be zero", 0.0, calculationResult, .000000001d);
		
	 }
	
	// Testing invalid row index above upper bound
	@Test
	 public void testCalculateRowTotalRowIndexAUB() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));
	        }
	    });
	     
		double calculationResult = DataUtilities.calculateRowTotal(values, 1);
	    assertEquals("Calculate total with AUB row index should be zero", 0.0, calculationResult, .000000001d);
		
	 }
	
	// Testing valid row index and data parameter which contains positive values (overloaded)
		@Test
		 public void testCalculateRowTotalPositiveValuesOverloaded() {
			
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getRowCount();
		            will(returnValue(1));
		            one(values).getValue(0, 0);
		            will(returnValue(4.0));
		            one(values).getValue(0, 1);
		            will(returnValue(4.0));	            
		        }
		    });
		    
		    int[] validCols = {0, 1};

		     double calculationResult = DataUtilities.calculateRowTotal(values, 0, validCols);
		     assertEquals("Row 0 total after 4.0 + 4.0", 8.0, calculationResult, .000000001d);
		 }
		
		// Testing valid row index and data parameter which contains null values (overloaded)
		@Test
		 public void testCalculateRowTotalNullValuesOverloaded() {
					
					Mockery mockingContext = new Mockery();
				    final Values2D values = mockingContext.mock(Values2D.class);
				    mockingContext.checking(new Expectations() {
				        {
				            one(values).getColumnCount();
				            will(returnValue(2));
				            one(values).getRowCount();
				            will(returnValue(1));
				            one(values).getValue(0, 0);
				            will(returnValue(null));
				            one(values).getValue(0, 1);
				            will(returnValue(null));	            
				        }
				    });
				    
				    int[] validCols = {0, 1};

				     double calculationResult = DataUtilities.calculateRowTotal(values, 0, validCols);
				     assertEquals("Row 0 total after null + null", 0, calculationResult, .000000001d);
				 }
		
		// Testing negative column/row count (overloaded)
		@Test
		 public void testCalculateRowTotalNegativeColCountOverloaded() {
			
			Mockery mockingContext = new Mockery();
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(-1));
		            one(values).getRowCount();
		            will(returnValue(-1));	            
		        }
		    });
		    
		     int[] validCols = {0, 1};

		     double calculationResult = DataUtilities.calculateRowTotal(values, 0, validCols);
		     assertEquals("Row 0 total after null + null", 0, calculationResult, .000000001d);
		 }
		
		
				
		
	
	// Testing invalid null data parameter
	
	@Test (expected = InvalidParameterException.class)
	 public void testCreateNumberArrayNullData() throws InvalidParameterException {
		
		double[] inputData = null;
	     
	    DataUtilities.createNumberArray(inputData);
		
	 }
	
	// Testing empty data parameter
	
	@Test
	 public void testCreateNumberArrayEmptyData() {
		
		double[] inputData = {};
		Number[] expectedData = {};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with empty data", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with positive values
	@Test
	 public void testCreateNumberArrayPositiveValues() {
		
		double[] inputData = {4.0, 4.0, 12.0, 14.0};
		Number[] expectedData = {4.0, 4.0, 12.0, 14.0};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive values", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with negative values

	@Test
	 public void testCreateNumberArrayNegativeValues() {
		
		double[] inputData = {-1.0, -2.0, -3.0, -4.0};
		Number[] expectedData = {-1.0, -2.0, -3.0, -4.0};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with negative values", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with positive decimal values

	@Test
	 public void testCreateNumberArrayPositiveDecimalValues() {
		
		double[] inputData = {1.11, 2.22, 3.33, 4.44};
		Number[] expectedData = {1.11, 2.22, 3.33, 4.44};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive decimal values", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with negative decimal values

	@Test
	 public void testCreateNumberArrayNegativeDecimalValues() {
		
		double[] inputData = {-1.11, -2.22, -3.33, -4.44};
		Number[] expectedData = {-1.11, -2.22, -3.33, -4.44};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive decimal values", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with smallest normal value

	@Test
	 public void testCreateNumberArrayLBValues() {
		
		double[] inputData = {Double.MIN_NORMAL};
		Number[] expectedData = {Double.MIN_NORMAL};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with smallest positive normal value", expectedData, arrayResult);
		
	 }
	
	// Testing valid data parameter with maximum positive value

	@Test
	 public void testCreateNumberArrayUBValues() {
		
		double[] inputData = {Double.MAX_VALUE};
		Number[] expectedData = {Double.MAX_VALUE};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with largest positive value", expectedData, arrayResult);
		
	 }

	// Testing calculateColumnTotal(Values2D data, int column)

	// Sample Test Case provided by SENG 438 Lab Document
	@Test
	public void calculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	// Test a null data parameter which is invalid
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalNullData() {
		double actualColumnTotal = DataUtilities.calculateColumnTotal(null, 0);
	}

	// Test an empty data parameter
	@Test
	public void calculateColumnTotalEmpty() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
			}
		});

		double expectedColumnTotal = 0;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The column total for empty object should be 0", expectedColumnTotal, actualColumnTotal,
				.000000001d);
	}

	// Test a valid data parameter with positive values and positive index and other
	// values in other columns
	@Test
	public void calculateColumnTotalPositiveTableAndValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(1000));
				one(values).getValue(0, 1);
				will(returnValue(14));
				one(values).getValue(0, 2);
				will(returnValue(1000));

				one(values).getValue(1, 1);
				will(returnValue(24));

				one(values).getValue(2, 1);
				will(returnValue(34));
			}
		});

		double expectedColumnTotal = 72;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("The column total should be 72", expectedColumnTotal, actualColumnTotal, .000000001d);
	}

	// Test a valid data parameter with positive values and positive index and other
	// values in other columns
	@Test
	public void calculateColumnTotalNegativeValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(-1000));
				one(values).getValue(0, 1);
				will(returnValue(-14));
				one(values).getValue(0, 2);
				will(returnValue(-1000));

				one(values).getValue(1, 1);
				will(returnValue(-24));

				one(values).getValue(2, 1);
				will(returnValue(-34));
			}
		});

		double expectedColumnTotal = -72;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("The column total should be -72", expectedColumnTotal, actualColumnTotal, .000000001d);
	}

	// Test a valid data parameter with positive values and negative index
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalNegativeColumn() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(1000));
			}
		});

		double expectedColumnTotal = 0;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals("The column total should be 0", expectedColumnTotal, actualColumnTotal, .000000001d);
	}
	
	// Test a valid data parameter with positive values and positive index and other
		// values in other columns
		@Test
		public void calculateColumnTotalPositiveTableAndNullValues() {
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);

			mockingContext.checking(new Expectations() {
				{
					one(values).getRowCount();
					will(returnValue(3));

					one(values).getValue(0, 0);
					will(returnValue(null));
					one(values).getValue(0, 1);
					will(returnValue(null));
					one(values).getValue(0, 2);
					will(returnValue(null));

					one(values).getValue(1, 1);
					will(returnValue(null));

					one(values).getValue(2, 1);
					will(returnValue(null));
				}
			});

			double expectedColumnTotal = 0;
			double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 1);
			assertEquals("The column total should be 0", expectedColumnTotal, actualColumnTotal, .000000001d);
		}
	
	// Call overloaded method
	// Testing calculateColumnTotal(Values2D data, int column, int[] validRows)

		// Sample Test Case provided by SENG 438 Lab Document
		@Test
		public void calculateColumnTotalForTwoValuesOverloaded() {
			// setup
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					one(values).getRowCount();
					will(returnValue(2));
					one(values).getValue(0, 0);
					will(returnValue(7.5));
					one(values).getValue(1, 0);
					will(returnValue(2.5));
				}
			});
			// exercise
			int[] validRows = {0, 1};
			double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
			// verify
			assertEquals(result, 10.0, .000000001d);
			// tear-down: NONE in this test method
		}
	
	 //Parbir Code
	 //createNumberArray2D(double[][] data) Tests
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column positive value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayPositive() {
		 //create expected array
		 Number[][] expectedArray = {{1, 5},{2, 6}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{1, 5},{2, 6}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column negative value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayNegative() {
		 //create expected array
		 Number[][] expectedArray = {{-1, -5},{-2, -6}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{-1, -5},{-2, -6}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column positive decimal value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayPositiveDecimal() {
		 //create expected array
		 Number[][] expectedArray = {{1.0, 5.0},{2.0, 6.0}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{1.0, 5.0},{2.0, 6.0}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column negative decimal value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayNegativeDecimals() {
		 //create expected array
		 Number[][] expectedArray = {{-1.0, -5.0},{-2.0, -6.0}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{-1.0, -5.0},{-2.0, -6.0}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a null 2D array passed into createNumberArray2D
	  * The assert will throw an exception 
	  * **/
	 
	 @Test (expected = InvalidParameterException.class)
	 public void createNumber2DArrayNull() throws InvalidParameterException{
		 //try{
			 //create null array to pass through the method
			 double[][] inputArray = null;
			 //call method
			 DataUtilities.createNumberArray2D(inputArray);
			// fail("Should have thrown illegal argument exception");
		 	
		 	
		 //} catch (Exception e) {
			// assertEquals("The exception e thorwn type IllegalArgumentException",
			//		 IllegalArgumentException.class, e.getClass());
		 //
	 }

	 // Testing getCumulativePercentages(KeyedValues data)
		// EQUIVALENCE CLASSES
		
		// Test a null data parameter
		@Test(expected = InvalidParameterException.class)
		public void getCumulativePercentagesNullData() {
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(null);
		}
		
		// Test a non-null data parameter
		@Test
		public void getCumulativePercentagesNonNullData() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(3));
					allowing(keyedValues).getKeys();
					will(returnIterator(0, 1, 2));
					allowing(keyedValues).getValue(0);
					will(returnValue(5));
					allowing(keyedValues).getValue(1);
					will(returnValue(9));
					allowing(keyedValues).getValue(2);
					will(returnValue(2));
					allowing(keyedValues).getKey(0);
					will(returnValue(0));
					allowing(keyedValues).getKey(1);
					will(returnValue(1));
					allowing(keyedValues).getKey(2);
					will(returnValue(2));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
			assertNotNull("Cumulative percentage return value should not be null", actualCumulativePercentage);
		}
		
		// Test empty data
		@Test
		public void getCumulativePercentagesEmptyData() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(0));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
			assertEquals("Cumulative percentage return value for empty data argument should have 0 items", 0, actualCumulativePercentage.getItemCount());
		}
		
		// Test non-empty, non-zero data
		@Test
		public void getCumulativePercentagesNonEmptyData() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(3));
					allowing(keyedValues).getKeys();
					will(returnIterator(0, 1, 2));
					allowing(keyedValues).getValue(0);
					will(returnValue(5));
					allowing(keyedValues).getValue(1);
					will(returnValue(9));
					allowing(keyedValues).getValue(2);
					will(returnValue(2));
					allowing(keyedValues).getKey(0);
					will(returnValue(0));
					allowing(keyedValues).getKey(1);
					will(returnValue(1));
					allowing(keyedValues).getKey(2);
					will(returnValue(2));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
			assertEquals("Cumulative percentage return value for index 1 should be 0.875", 0.875, actualCumulativePercentage.getValue(1));
		}
		
//		// Test data with only zero for values
//		@Test
//		public void getCumulativePercentagesDataHasOnlyZeroes() {
//			Mockery mockingContext = new Mockery();
//			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
//			
//			mockingContext.checking(new Expectations() {
//				{
//					allowing(keyedValues).getItemCount();
//					will(returnValue(3));
//					allowing(keyedValues).getKeys();
//					will(returnIterator(0, 1, 2));
//					allowing(keyedValues).getValue(0);
//					will(returnValue(0));
//					allowing(keyedValues).getValue(1);
//					will(returnValue(0));
//					allowing(keyedValues).getValue(2);
//					will(returnValue(0));
//					allowing(keyedValues).getKey(0);
//					will(returnValue(0));
//					allowing(keyedValues).getKey(1);
//					will(returnValue(1));
//					allowing(keyedValues).getKey(2);
//					will(returnValue(2));
//				}
//			});
//			
//			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
//			assertTrue("Cumulative percentage return value for data argument with only zeroes should be NaN", Double.isNaN((double)actualCumulativePercentage.getValue(0)));
//		}
		
		// Test data with some zero and non-zero values
		@Test
		public void getCumulativePercentagesDataHasZeroesAndNonZeroes() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(3));
					allowing(keyedValues).getKeys();
					will(returnIterator(0, 1, 2));
					allowing(keyedValues).getValue(0);
					will(returnValue(5));
					allowing(keyedValues).getValue(1);
					will(returnValue(0));
					allowing(keyedValues).getValue(2);
					will(returnValue(2));
					allowing(keyedValues).getKey(0);
					will(returnValue(0));
					allowing(keyedValues).getKey(1);
					will(returnValue(1));
					allowing(keyedValues).getKey(2);
					will(returnValue(2));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
			assertEquals("Cumulative percentage return value for index 0 should be 0.714", 5.0/7.0, actualCumulativePercentage.getValue(0));
		}
		
		// Test data with negative values
		@Test(expected = InvalidParameterException.class)
		public void getCumulativePercentagesDataHasNegativeValues() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(3));
					allowing(keyedValues).getKeys();
					will(returnIterator(0, 1, 2));
					allowing(keyedValues).getValue(0);
					will(returnValue(-5));
					allowing(keyedValues).getValue(1);
					will(returnValue(-9));
					allowing(keyedValues).getValue(2);
					will(returnValue(-2));
					allowing(keyedValues).getKey(0);
					will(returnValue(0));
					allowing(keyedValues).getKey(1);
					will(returnValue(1));
					allowing(keyedValues).getKey(2);
					will(returnValue(2));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
		}
		
		// Assignment 3 Tests -----------------
		
		// Test getCumulativePercentages when it has a null value in a row
		@Test
		public void getCumulativePercentagesDataHasNullValue() {
			Mockery mockingContext = new Mockery();
			final KeyedValues keyedValues = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(new Expectations() {
				{
					allowing(keyedValues).getItemCount();
					will(returnValue(3));
					allowing(keyedValues).getKeys();
					will(returnIterator(0, 1, 2));
					allowing(keyedValues).getValue(0);
					will(returnValue(null));
					allowing(keyedValues).getValue(1);
					will(returnValue(9));
					allowing(keyedValues).getValue(2);
					will(returnValue(2));
					allowing(keyedValues).getKey(0);
					will(returnValue(0));
					allowing(keyedValues).getKey(1);
					will(returnValue(1));
					allowing(keyedValues).getKey(2);
					will(returnValue(2));
				}
			});
			
			KeyedValues actualCumulativePercentage = DataUtilities.getCumulativePercentages(keyedValues);
			assertEquals("Cumulative percentage return value for index 1 should be 0.81818", 9.0/11.0, actualCumulativePercentage.getValue(1));
		}

}
