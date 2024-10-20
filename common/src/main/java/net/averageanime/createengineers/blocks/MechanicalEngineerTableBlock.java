package net.averageanime.createengineers.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class MechanicalEngineerTableBlock extends TableBlock {

    public MechanicalEngineerTableBlock(Settings settings) {
        super(settings);
    }

    public static VoxelShape TABLE_SHAPE = VoxelShapes.union(

            VoxelShapes.cuboid(0, 0.25, 0, 1, 0.4375, 1),
            VoxelShapes.cuboid(0, 0, 0, 1, 0.25, 1),
            VoxelShapes.cuboid(-0.0625, 0.4375, 0.40625, 1.0625, 0.8125, 0.59375),
            VoxelShapes.cuboid(-0.0625, 0.4375, 0.40625, 1.0625, 0.8125, 0.59375),
            VoxelShapes.cuboid(0.40625, 0.4375, -0.0625, 0.59375, 0.8125, 1.0625),
            VoxelShapes.cuboid(0.40625, 0.4375, -0.0625, 0.59375, 0.8125, 1.0625),
            VoxelShapes.cuboid(0.125, 0.44375, 0.125, 0.875, 0.7562500000000001, 0.875),
            VoxelShapes.cuboid(0.25, 0.40625, 0.25, 0.75, 0.84375, 0.75),
            VoxelShapes.cuboid(0.1875, 0.4375, 0.1875, 0.8125, 0.8812500000000001, 0.8125),
            VoxelShapes.cuboid(0.0625, 0.875, 0.0625, 0.9375, 1, 0.9375),
            VoxelShapes.cuboid(0.8125, 0.8187500000000001, 0.625, 0.875, 0.9437500000000001, 0.75),
            VoxelShapes.cuboid(0.125, 0.8187500000000001, 0.25, 0.1875, 0.9437500000000001, 0.375),
            VoxelShapes.cuboid(0.25, 0.8187500000000001, 0.8125, 0.375, 0.9437500000000001, 0.875),
            VoxelShapes.cuboid(0.625, 0.8187500000000001, 0.125, 0.75, 0.9437500000000001, 0.1875),
            VoxelShapes.cuboid(0.8125, 0.8187500000000001, 0.25, 0.875, 0.9437500000000001, 0.375),
            VoxelShapes.cuboid(0.125, 0.8187500000000001, 0.625, 0.1875, 0.9437500000000001, 0.75),
            VoxelShapes.cuboid(0.625, 0.8187500000000001, 0.8125, 0.75, 0.9437500000000001, 0.875),
            VoxelShapes.cuboid(0.25, 0.8187500000000001, 0.125, 0.375, 0.9437500000000001, 0.1875)

    );

    public static VoxelShape TABLE_SHAPE_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, TABLE_SHAPE);
    public static VoxelShape TABLE_SHAPE_EAST = rotateShape(Direction.NORTH, Direction.EAST, TABLE_SHAPE);
    public static VoxelShape TABLE_SHAPE_WEST = rotateShape(Direction.NORTH, Direction.WEST, TABLE_SHAPE);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH -> {return TABLE_SHAPE;}
            case SOUTH -> {return TABLE_SHAPE_SOUTH;}
            case WEST -> {return TABLE_SHAPE_WEST;}
            default -> {return TABLE_SHAPE_EAST;}
        }
    }
}
