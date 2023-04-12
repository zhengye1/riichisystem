package com.vincent.riichisystem.game.enumeration;

/**
 * @author Vincent Zheng
 */

public enum TieBreaker {
    /**
     * DIVIDE_EQUALLY means once tie happen, split the uma
     * WIND_ORDER means if ties, higher rank will be giving by following order EAST -> SOUTH -> WEST -> NORTH
     */
    DIVIDE_EQUALLY, WIND_ORDER
}
