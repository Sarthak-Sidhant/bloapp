package org.apache.commons.lang3.concurrent.locks;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class LockingVisitors {

    public static class LockVisitor<O, L> {
        private final L lock;
        private final O object;
        private final Supplier<Lock> readLockSupplier;
        private final Supplier<Lock> writeLockSupplier;

        protected LockVisitor(O o, L l, Supplier<Lock> supplier, Supplier<Lock> supplier2) {
            this.object = (O) Objects.requireNonNull(o, "object");
            this.lock = (L) Objects.requireNonNull(l, "lock");
            this.readLockSupplier = (Supplier) Objects.requireNonNull(supplier, "readLockSupplier");
            this.writeLockSupplier = (Supplier) Objects.requireNonNull(supplier2, "writeLockSupplier");
        }

        public void acceptReadLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.readLockSupplier, failableConsumer);
        }

        public void acceptWriteLocked(FailableConsumer<O, ?> failableConsumer) {
            lockAcceptUnlock(this.writeLockSupplier, failableConsumer);
        }

        public <T> T applyReadLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.readLockSupplier, failableFunction);
        }

        public <T> T applyWriteLocked(FailableFunction<O, T, ?> failableFunction) {
            return (T) lockApplyUnlock(this.writeLockSupplier, failableFunction);
        }

        public L getLock() {
            return this.lock;
        }

        public O getObject() {
            return this.object;
        }

        protected void lockAcceptUnlock(Supplier<Lock> supplier, FailableConsumer<O, ?> failableConsumer) {
            Lock lock = supplier.get();
            lock.lock();
            try {
                failableConsumer.accept(this.object);
                lock.unlock();
            } catch (Throwable th) {
                try {
                    throw Failable.rethrow(th);
                } catch (Throwable th2) {
                    lock.unlock();
                    throw th2;
                }
            }
        }

        protected <T> T lockApplyUnlock(Supplier<Lock> supplier, FailableFunction<O, T, ?> failableFunction) {
            Lock lock = supplier.get();
            lock.lock();
            try {
                T tApply = failableFunction.apply(this.object);
                lock.unlock();
                return tApply;
            } catch (Throwable th) {
                try {
                    throw Failable.rethrow(th);
                } catch (Throwable th2) {
                    lock.unlock();
                    throw th2;
                }
            }
        }
    }

    public static class ReadWriteLockVisitor<O> extends LockVisitor<O, ReadWriteLock> {
        protected ReadWriteLockVisitor(O o, final ReadWriteLock readWriteLock) {
            readWriteLock.getClass();
            Supplier supplier = new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return readWriteLock.readLock();
                }
            };
            readWriteLock.getClass();
            super(o, readWriteLock, supplier, new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$ReadWriteLockVisitor$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return readWriteLock.writeLock();
                }
            });
        }
    }

    public static class StampedLockVisitor<O> extends LockVisitor<O, StampedLock> {
        protected StampedLockVisitor(O o, final StampedLock stampedLock) {
            stampedLock.getClass();
            Supplier supplier = new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return stampedLock.asReadLock();
                }
            };
            stampedLock.getClass();
            super(o, stampedLock, supplier, new Supplier() { // from class: org.apache.commons.lang3.concurrent.locks.LockingVisitors$StampedLockVisitor$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return stampedLock.asWriteLock();
                }
            });
        }
    }

    public static <O> ReadWriteLockVisitor<O> create(O o, ReadWriteLock readWriteLock) {
        return new ReadWriteLockVisitor<>(o, readWriteLock);
    }

    public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O o) {
        return create(o, new ReentrantReadWriteLock());
    }

    public static <O> StampedLockVisitor<O> stampedLockVisitor(O o) {
        return new StampedLockVisitor<>(o, new StampedLock());
    }
}
