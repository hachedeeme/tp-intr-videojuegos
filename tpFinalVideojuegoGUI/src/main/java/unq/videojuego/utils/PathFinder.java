package unq.videojuego.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import unq.videojuego.components.BattleComponent;

public class PathFinder {
	public static PathFinder INSTANCE = new PathFinder();
	
	public List<TTuple> getArea(Map<Integer, Map<Integer, BattleComponent>> map, int mapWidth, int mapHeight, Point start, int count){
		List<TTuple> list = new ArrayList<TTuple>();
		TTuple startTuple = new TTuple(start, 0);
		list.add(startTuple);
		List<TTuple> temp = new ArrayList<TTuple>(list);
		List<TTuple> temp2 = new ArrayList<TTuple>();
		List<TTuple> temp3 = new ArrayList<TTuple>();
		
		for (int i = 0; i < count; i++) {
			for (TTuple tuple : new ArrayList<TTuple>(temp)){
				temp3 = this.getAdyacentDirections(list, map, tuple, mapWidth, mapHeight);
				temp2.addAll(temp3);
				list.addAll(temp3);
			}
			temp = temp2;
			temp2 = new ArrayList<TTuple>();
			//list.addAll(temp);
		}
		
		list.remove(startTuple);
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
			boolean isOutOfMap = ! (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight);
			if (isOutOfMap) {
				list.remove(newTuple);
			} else if (map.get(x).containsKey(y)){
				list.remove(newTuple);
			}
		}
		
		
		
		this.removeMatched(list, mainList);
		return list;
	}

	private void removeMatched(List<TTuple> list, List<TTuple> mainList) {
		for (TTuple tuple : new ArrayList<TTuple>(list)){
			for (TTuple mainTuple : new ArrayList<TTuple>(mainList)){
				if (mainTuple.equalsCoords(tuple)){
					
					if (mainTuple.counterSmallerOrEqual(tuple)){
						list.remove(tuple);
					}
					else {
						mainList.remove(mainTuple);
					}
				}
			}
		}
	}
}
