/**
 * Copyright (c) 2006-2010 Berlin Brown and botnode.com/Berlin Research  All Rights Reserved
 *
 * http://www.opensource.org/licenses/bsd-license.php

 * All rights reserved.

 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:

 * * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * * Neither the name of the Botnode.com (Berlin Brown) nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Date: 2/15/2010 
 *   
 * Home Page: http://botnode.com/
 * 
 * Contact: Berlin Brown <berlin dot brown at gmail.com>
 */

// MyTronBot.java
// Author: Berlin Brown

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * My Tron Bot
 * 
 * @author BerlinBrown
 *
 */
class MyTronBot {
    
    public static String B = Vers.V;
    
    public static String MakeMove() {
                
        final int x = Map.MyX();
        final int y = Map.MyY();
        
        final List<String> validMoves = new ArrayList<String>();
        
        if (!Map.IsWall(x, y - 1)) {
            validMoves.add("North");
        }
        if (!Map.IsWall(x + 1, y)) {
            validMoves.add("East");
        }
        if (!Map.IsWall(x, y + 1)) {
            validMoves.add("South");
        }
        if (!Map.IsWall(x - 1, y)) {
            validMoves.add("West");
        }
                        
        /////////////////////////////////////////
        
        if (validMoves.size() == 0) {
            return "North"; // Hopeless. Might as well go North!
        } else {
            final Random rand = new Random();
            int whichMove = rand.nextInt(validMoves.size());
            return validMoves.get(whichMove);
        }
    }

    /////////////////////////////////////////////
    //
    // Ignore this method. It's just doing boring stuff like communicating
    // with the contest tournament engine.
    //
    /////////////////////////////////////////////
    public static void main(String[] args) {
        
        while (true) {
            Map.Initialize();
            Map.MakeMove(MakeMove());
        }
        
    } // End of the Class //
    
} // End of the class //
