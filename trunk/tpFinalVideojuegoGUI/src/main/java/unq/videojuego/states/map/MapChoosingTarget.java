package unq.videojuego.states.map;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
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
            BattleEnemy enemy = map.getEnemy(selectedTuple);
           
            if (isInSelectionArea && enemy != null){
                map.removeSelectedTile();
                this.setFacingDir((BattleCharacter) map.getSelectedUnit(), enemy);
                map.getSelectedUnit().setState(new CharAttacking());
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

    private void setFacingDir(BattleCharacter character, BattleEnemy enemy) {
        UnitDir wantedDir;
       
        int cx = character.getMapX();
        int cy = character.getMapY();
        int ex = enemy.getMapX();
        int ey = enemy.getMapY();

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
       
        character.setDir(wantedDir);
    }
}
