/**
Copyright (c) 2011, The EDMOAL Project

	DLR Deutsches Zentrum fuer Luft- und Raumfahrt e.V.
	German Aerospace Center e.V.
	Institut fuer Flugfuehrung/Institute of Flight Guidance
	Tel. +49 531 295 2500, Fax: +49 531 295 2550
	WWW: http://www.dlr.de/fl/		
 
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
    	this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
    	this list of conditions and the following disclaimer in the documentation and/or
    	other materials provided with the distribution.
    * Neither the name of the DLR nor the names of its contributors
    	may be used to endorse or promote products derived from this software
    	without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
*/


package dataMiningTestTrack;

import data.structures.balltree.BallTree;
import dataMiningTestTrack.tests.ClusterAlgorithmVisualTest;
import dataMiningTestTrack.tests.DataStructureSpeedTest;
import dataMiningTestTrack.tests.DataStructureVisualTest;

/**
 * Since the EDMOAL project is just an API, a main class would not be necessary to provide.
 * In fact, it is very likely that it will vanish in due time. For now, the main function and all the
 * classes in this package are provided for the user to get some examples, how to use EDMOAL.<br>
 * 
 * Many commands are deactivated by line comments. Please activate them as you wish.
 * 
 * @author Roland Winkler
 */
public class Main
{
	/**
	 * Decide whether you want to visually test some algorithms or if zyou like to
	 * perform a performance test of the various aspects of EDMOAL.
	 * 
	 * @param args The command arguments. They are ignored for now.
	 */
	public static void main(String[] args)
	{

//		Main.dataStructureVisualTest();
//		Main.dataStructureSpeedTest();
		Main.clusterAlgorithmVisualTest();
		
	}
	
	
	/**
	 * Performs a test of the data structure algorithms like the {@link BallTree} and visualises
	 * the result such that the properties of the data structure become visible.
	 */
	public static void dataStructureVisualTest()
	{
		DataStructureVisualTest visualTest = new DataStructureVisualTest(10000);
		visualTest.ballTreeStructureTest(); System.gc();
//		visualTest.centeredBallTreeStructureTest(); System.gc();
	}
	

	/**
	 * Performs a test of the data structures w.r.t. to their time consumption on certain tasks.
	 * Please refrain from applying other applications that require high CPU power or need a lot
	 * of memory bandwidth.
	 */
	public static void dataStructureSpeedTest()
	{
		long milliseconds = 0;		
		int dim = 2, number = 10000000, queryNumber = 100000;
		
		System.out.println("===== Randomly Generated Data Set =====");
		System.out.print("Build data set ("+dim+" dim, "+number+" obj) .. ");
		milliseconds = -System.currentTimeMillis();
		DataStructureSpeedTest speedTest = new DataStructureSpeedTest(dim, number, queryNumber);
		milliseconds += System.currentTimeMillis();
		System.out.print("done: "+ milliseconds + "ms");
//		speedTest.showSimplifiedDataSet(20000);
		speedTest.ballTreeSpeedTest();System.gc();
		speedTest.centeredBallTreeSpeedTest();System.gc();
	}
	
	/**
	 * Performs tests of the clustering algorithms, using synthetic data sets.
	 * The result is visualised so that the result of the algorithm is easily
	 * interpretable. The point of these tests is, to give the user some
	 * feeling of how the algorithms behave and to decide whether or not they
	 * might be useful for him.
	 */
	public static void clusterAlgorithmVisualTest()
	{
		int dim = 3, number = 3000, clusterCount = 2*dim-1;
		
		ClusterAlgorithmVisualTest clusterTest = new ClusterAlgorithmVisualTest(dim, number, clusterCount);
//		clusterTest.showDataSet();
//		clusterTest.showClusteredDataSet();
//		clusterTest.testHardCMeans();
//		clusterTest.testFuzzyCMeans();
//		clusterTest.testFuzzyCMeansNoise();
//		clusterTest.testPolynomialFuzzyCMeans();
		clusterTest.testPolynomialFuzzyCMeansNoise();
//		clusterTest.testRewardingCrispFCM();		
//		clusterTest.testRewardingCrispFCMNoise();
//		clusterTest.testVoronoiPartitionFCM();		
//		clusterTest.testVoronoiPartitionFCMNoise(); 
//		clusterTest.testDistAdaptedFCM(); 
//		clusterTest.testDistAdaptedFCMNoise();
//		clusterTest.testBallTreeFuzzyCMeans();
//		clusterTest.testExpectationMaximization();
//		clusterTest.testDBScan();
		
	}
}
