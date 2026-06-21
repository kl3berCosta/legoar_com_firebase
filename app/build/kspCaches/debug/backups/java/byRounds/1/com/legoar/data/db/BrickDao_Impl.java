package com.legoar.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BrickDao_Impl implements BrickDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BrickEntity> __insertionAdapterOfBrickEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteBrick;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBricksForProject;

  public BrickDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBrickEntity = new EntityInsertionAdapter<BrickEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `bricks` (`id`,`projectId`,`type`,`color`,`gridX`,`gridY`,`gridZ`,`rotationY`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BrickEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getProjectId());
        statement.bindString(3, entity.getType());
        statement.bindString(4, entity.getColor());
        statement.bindLong(5, entity.getGridX());
        statement.bindLong(6, entity.getGridY());
        statement.bindLong(7, entity.getGridZ());
        statement.bindLong(8, entity.getRotationY());
      }
    };
    this.__preparedStmtOfDeleteBrick = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM bricks WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllBricksForProject = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM bricks WHERE projectId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBrick(final BrickEntity brick, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBrickEntity.insert(brick);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertBricks(final List<BrickEntity> bricks,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBrickEntity.insert(bricks);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBrick(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteBrick.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteBrick.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllBricksForProject(final String projectId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBricksForProject.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, projectId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllBricksForProject.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BrickEntity>> observeBricksForProject(final String projectId) {
    final String _sql = "SELECT * FROM bricks WHERE projectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, projectId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bricks"}, new Callable<List<BrickEntity>>() {
      @Override
      @NonNull
      public List<BrickEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "projectId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfGridX = CursorUtil.getColumnIndexOrThrow(_cursor, "gridX");
          final int _cursorIndexOfGridY = CursorUtil.getColumnIndexOrThrow(_cursor, "gridY");
          final int _cursorIndexOfGridZ = CursorUtil.getColumnIndexOrThrow(_cursor, "gridZ");
          final int _cursorIndexOfRotationY = CursorUtil.getColumnIndexOrThrow(_cursor, "rotationY");
          final List<BrickEntity> _result = new ArrayList<BrickEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BrickEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpProjectId;
            _tmpProjectId = _cursor.getString(_cursorIndexOfProjectId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpColor;
            _tmpColor = _cursor.getString(_cursorIndexOfColor);
            final int _tmpGridX;
            _tmpGridX = _cursor.getInt(_cursorIndexOfGridX);
            final int _tmpGridY;
            _tmpGridY = _cursor.getInt(_cursorIndexOfGridY);
            final int _tmpGridZ;
            _tmpGridZ = _cursor.getInt(_cursorIndexOfGridZ);
            final int _tmpRotationY;
            _tmpRotationY = _cursor.getInt(_cursorIndexOfRotationY);
            _item = new BrickEntity(_tmpId,_tmpProjectId,_tmpType,_tmpColor,_tmpGridX,_tmpGridY,_tmpGridZ,_tmpRotationY);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getBricksForProject(final String projectId,
      final Continuation<? super List<BrickEntity>> $completion) {
    final String _sql = "SELECT * FROM bricks WHERE projectId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, projectId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<BrickEntity>>() {
      @Override
      @NonNull
      public List<BrickEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfProjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "projectId");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfGridX = CursorUtil.getColumnIndexOrThrow(_cursor, "gridX");
          final int _cursorIndexOfGridY = CursorUtil.getColumnIndexOrThrow(_cursor, "gridY");
          final int _cursorIndexOfGridZ = CursorUtil.getColumnIndexOrThrow(_cursor, "gridZ");
          final int _cursorIndexOfRotationY = CursorUtil.getColumnIndexOrThrow(_cursor, "rotationY");
          final List<BrickEntity> _result = new ArrayList<BrickEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BrickEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpProjectId;
            _tmpProjectId = _cursor.getString(_cursorIndexOfProjectId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpColor;
            _tmpColor = _cursor.getString(_cursorIndexOfColor);
            final int _tmpGridX;
            _tmpGridX = _cursor.getInt(_cursorIndexOfGridX);
            final int _tmpGridY;
            _tmpGridY = _cursor.getInt(_cursorIndexOfGridY);
            final int _tmpGridZ;
            _tmpGridZ = _cursor.getInt(_cursorIndexOfGridZ);
            final int _tmpRotationY;
            _tmpRotationY = _cursor.getInt(_cursorIndexOfRotationY);
            _item = new BrickEntity(_tmpId,_tmpProjectId,_tmpType,_tmpColor,_tmpGridX,_tmpGridY,_tmpGridZ,_tmpRotationY);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
