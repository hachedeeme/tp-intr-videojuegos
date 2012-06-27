package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.units.UnitAttacking;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;
import com.uqbar.vainilla.sound.SoundHandler;

public class MapChoosingTarget extends State {

    public MapChoosingTarget() {
        super("ChoosingTarget");
    }

    @Override
    public void update(GameComponent comp, DeltaState deltaState) {
        BattleMap map = (BattleMap) comp;
        BattleScene scene = map.getScene();
        if (deltaState.isKeyPressed(Key.X)){
            TTuple selectedTuple = new TTuple(map.getSelectedTile().getMapX(), map.getSelectedTile().getMapY());
            TTuple selectedTupleWithCounter = selectedTuple.getTupleFromCoords(map.getAreaTuples());
            boolean isInSelectionArea = selectedTupleWithCounter != null;
            BattleUnit target = map.getUnit(selectedTuple);
           
            if (isInSelectionArea && target != null){
                map.removeSelectedTile();
                map.getSelectedUnit().setFacingDir(target);
                map.getSelectedUnit().setState(new UnitAttacking(target));
                map.setState(new Sleeping());
                map.removeArea();
                scene.setAttacked(true);
            }
        } else if (deltaState.isKeyPressed(Key.Z)){
        	SoundHandler.INSTANCE.playSound("Cancel");
            scene.addActiveWindow(scene.getBattleCommandsWindow());
            map.removeSelectedTile();
            map.addSelectedTileInSelectedUnit();
            map.removeArea();
            map.setState(new MapWaitingForCommand());
        }
       
    }

}
