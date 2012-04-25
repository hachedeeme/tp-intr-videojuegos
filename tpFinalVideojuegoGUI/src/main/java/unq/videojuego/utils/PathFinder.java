package unq.videojuego.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import unq.videojuego.components.BattleComponent;

public class PathFinder {
	public static PathFinder INSTANCE = new PathFinder();
	
	public List<TTuple> getPath(Map<Integer, Map<Integer, BattleComponent>> map, int mapWidth, int mapHeight, Point start, Point end){
		List<TTuple> list = new ArrayList<TTuple>();
		list.add(new TTuple(end, 0));
		
		for (TTuple tuple : list){
			this.getAdyacentDirections(list, map, tuple, mapWidth, mapHeight);
			
		}
		
		return list;
	}

	private List<TTuple> getAdyacentDirections(List<TTuple> mainList, Map<Integer, Map<Integer, BattleComponent>> map, TTuple tuple, int mapWidth, int mapHeight) {
		List<TTuple> list = new ArrayList<TTuple>();
		list.add(new TTuple(tuple.getX(), tuple.getY()-1, tuple.getCounter()+1));
		list.add(new TTuple(tuple.getX()+1, tuple.getY(), tuple.getCounter()+1));
		list.add(new TTuple(tuple.getX(), tuple.getY()+1, tuple.getCounter()+1));
		list.add(new TTuple(tuple.getX()-1, tuple.getY(), tuple.getCounter()+1));
		
		for (TTuple newTuple : new ArrayList<TTuple>(list)){
			int x = newTuple.getX();
			int y = newTuple.getY();
			if (x >= 0 && x < mapWidth &&
				y >= 0 && y < mapHeight){
				if (map.get(x).containsKey(y)){
					list.remove(newTuple);
				}
			}
		}
		
		return list;
	}
	
}
