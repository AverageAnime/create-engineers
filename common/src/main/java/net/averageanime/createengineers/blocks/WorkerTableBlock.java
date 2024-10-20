package net.averageanime.createengineers.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WorkerTableBlock extends TableBlock {

    public WorkerTableBlock(Settings settings) {
        super(settings);
    }

    public static VoxelShape TABLE_SHAPE = VoxelShapes.union(

            VoxelShapes.cuboid(0.84375, 0.84375, 0.25, 1.03125, 1.03125, 0.75),
            VoxelShapes.cuboid(-0.03125, 0.84375, 0.25, 0.15625, 1.03125, 0.75),
            VoxelShapes.cuboid(0.25, 0.84375, 0.84375, 0.75, 1.03125, 1.03125),
            VoxelShapes.cuboid(0.25, 0.84375, -0.03125, 0.75, 1.03125, 0.15625),
            VoxelShapes.cuboid(0.1875, 0.75, 0.1875, 0.8125, 1, 0.8125),
            VoxelShapes.cuboid(0.125, 0.6875, 0.0625, 0.875, 0.9375, 0.9375),
            VoxelShapes.cuboid(0.375, 0.125, 0, 0.625, 0.625, 1),
            VoxelShapes.cuboid(0.25, 0.625, 0, 0.75, 0.6875, 1),
            VoxelShapes.cuboid(0, 0.125, 0.375, 1, 0.625, 0.625),
            VoxelShapes.cuboid(0, 0.625, 0.25, 1, 0.6875, 0.75),
            VoxelShapes.cuboid(0.5, 0.875, 0, 1, 1, 0.125),
            VoxelShapes.cuboid(0.875, 0.875, 0.125, 1, 1, 0.875),
            VoxelShapes.cuboid(0, 0.875, 0.125, 0.125, 1, 0.875),
            VoxelShapes.cuboid(0.5, 0.875, 0.875, 1, 1, 1),
            VoxelShapes.cuboid(0, 0.875, 0.875, 0.5, 1, 1),
            VoxelShapes.cuboid(0, 0.875, 0, 0.5, 1, 0.125),
            VoxelShapes.cuboid(0, 0.6875, 0, 0.125, 0.875, 1),
            VoxelShapes.cuboid(0.875, 0.6875, 0, 1, 0.875, 1),
            VoxelShapes.cuboid(0.125, 0.6875, 0.875, 0.875, 0.875, 1),
            VoxelShapes.cuboid(0.125, 0.6875, 0, 0.875, 0.875, 0.125),
            VoxelShapes.cuboid(0.125, 0.6875, 0.125, 0.875, 0.875, 0.875),
            VoxelShapes.cuboid(0.25, 0, 0.75, 0.75, 0.0625, 1),
            VoxelShapes.cuboid(0.25, 0, 0, 0.75, 0.0625, 0.25),
            VoxelShapes.cuboid(0, 0, 0.25, 1, 0.0625, 0.75),
            VoxelShapes.cuboid(0, 0.0625, 0.25, 1, 0.125, 0.75),
            VoxelShapes.cuboid(0.25, 0.0625, 0, 0.75, 0.125, 1)

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
