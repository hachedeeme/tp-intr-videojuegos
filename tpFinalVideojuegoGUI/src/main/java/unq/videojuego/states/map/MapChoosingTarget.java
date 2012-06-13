package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.character.CharAttacking;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapChoosingTarget extends State {

    public MapChoosingTarget() {
        super("ChoosingTarget");
    }

    @Override
    public void update(GameComponent comp, DeltaState deltaState) {
        BattleMap map = (BattleMap) comp;
        if (deltaState.isKeyPressed(Key.X)){
            TTuple selectedTuple = new TTuple(map.getSelectedTile().getMapX(), map.getSelectedTile().getMapY());
            TTuple selectedTupleWithCounter = selectedTuple.getTupleFromCoords(map.getAreaTuples());
            boolean isInSelectionArea = selectedTupleWithCounter != null;
            BattleUnit target = map.getUnit(selectedTuple);
           
            if (isInSelectionArea && target != null){
                map.removeSelectedTile();
                this.setFacingDir(map.getSelectedUnit(), target);
                map.getSelectedUnit().setState(new CharAttacking(target));
                map.setState(new Sleeping());
                map.removeArea();
            }
        } else if (deltaState.isKeyPressed(Key.Z)){
            BattleScene scene = map.getScene();
            scene.addActiveWindow(scene.getBattleCommandsWindow());
            map.removeSelectedTile();
            map.addSelectedTileInSelectedUnit();
            map.removeArea();
            map.setState(new MapWaitingForCommand());
        }
       
    }

    private void setFacingDir(BattleUnit caster, BattleUnit target) {
        UnitDir wantedDir;
       
        int cx = caster.getMapX();
        int cy = caster.getMapY();
        int ex = target.getMapX();
        int ey = target.getMapY();

        if (cx < ex){
            wantedDir = UnitDir.Right;
        } else {
            wantedDir = UnitDir.Left;
        }
         
        if (Math.abs(cx - ex) < Math.abs(cy - ey)){
            if (cy < ey){
                wantedDir = UnitDir.Down;
            } else {
                wantedDir = UnitDir.Up;
            }
        }
       
        caster.setDir(wantedDir);
    }
}
