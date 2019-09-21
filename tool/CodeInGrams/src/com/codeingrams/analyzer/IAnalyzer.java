/*
 * Analyser Interface
 */
package com.codeingrams.analyzer;

import java.io.IOException;

public interface IAnalyzer {

	public void run(String path) throws IOException;
	
}
