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


package data.structures.order;

import java.io.Serializable;

import data.set.IndexedDataObject;

/**
 * This is a container class for ordering a dynamic number of <code>IndexedDataObject</code>s w.r.t. a specific property. 
 * 
 * @author Roland Winkler
 */
public class OrderedDataObject<T> implements Comparable<OrderedDataObject<T>>, Serializable
{	
	/**  */
	private static final long	serialVersionUID	= 5049956479112818499L;

	/** The <code>IndexedDataObject</code> that is put into some sort of ordering */
	public IndexedDataObject<T> dataObject;
	
	/** The property that should be used for the ordering. */
	public double compare;


	/**
	 * Creates a new  <code>OrderedDataObject</code>.
	 * 
	 * @param dataObject The <code>IndexedDataObject</code> to store
	 * @param compare The comparable property to store
	 */
	public OrderedDataObject(IndexedDataObject<T> dataObject, double compare)
	{
		this.dataObject = dataObject;
		this.compare = compare;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(OrderedDataObject<T> o)
	{
		if(o.compare == this.compare) return 0;
		
		return ((this.compare < o.compare)? -1 : 1);
	}
}
